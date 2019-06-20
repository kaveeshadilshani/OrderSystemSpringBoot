package com.hellokoding.springboot.bean;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;
import java.util.Queue;

import static com.hellokoding.springboot.UserController1.userRepository1;
public class JMSSender {
    private static final Logger logger = LogManager.getLogger("JMSSender");
    private static String compID = "OMS-DEFAULT";
    MessageProducer publisher = null;
    Connection connection = null;
    Session session = null;
    Context ic = null ;
    ConnectionFactory cf = null;
    public static Context getInitialContext() throws NamingException
    {
        Properties p = new Properties();
        String ip = userRepository1.findById((long)userRepository1.count()).get().getIp();
        String port = Integer.toString(userRepository1.findById((long)userRepository1.count()).get().getPort());
        String providerURL = "http-remoting://"+ip+":"+port;
        System.out.println(providerURL);
        //if(Settings.MIDDLEWARE.equals("JMS")){
            p.put("java.naming.factory.initial","org.jboss.naming.remote.client.InitialContextFactory");
            p.put("java.naming.factory.url.pkgs", " org.jboss.naming:org.jnp.interfaces");
            p.put("java.naming.provider.url",providerURL);
            if (Settings.Q_USERNAME != null && Settings.Q_PASSWORD != null) {
                p.put("java.naming.security.principal", "dfix");
                p.put("java.naming.security.credentials", "dfix_1234");
            }
       // }
        return new InitialContext(p);
    }

    public void createConnection(){
        JMS jms = new JMS();
        String exchange = jms.getExchange();
        String destinationName ="jms/queue/FromExchange";
        if( "ToExchange".equals(exchange)){
            destinationName = "jms/queue/ToExchange";
        }

        try
        {
            ic = getInitialContext();
            cf = (ConnectionFactory)ic.lookup("jms/RemoteConnectionFactorySTP");
            Object object = ic.lookup(destinationName);

            if (Settings.Q_USERNAME != null && Settings.Q_PASSWORD != null) {
                connection = cf.createConnection("dfix","dfix_1234");
            } else {
                connection = cf.createConnection();
            }
            session = connection.createSession(false, 1);
            publisher = session.createProducer((Destination) object);


            connection.start();
        }
        catch (Exception e){
            System.out.println(e);
            logger.error("Can't create jms session: " + e.getMessage());
        }
    }

    public void sendMessage(String eventType, String sessionID, String msgData)
    {
        try
        {
            if (Settings.FILE_TYPE.equals("DFIX")) {
                TextMessage text = session.createTextMessage();
                StringBuilder msgBuild = new StringBuilder();
                msgBuild.append(sessionID).append("\u001C").append(0).append("\u001C").append(eventType);
                msgBuild.append("\u001C").append(msgData);
                text.setText(msgBuild.toString());
                publisher.send(text);
                logger.info("Msg sent to OMS:session:" + sessionID + " message:" + msgData);
            } else {
                MapMessage map = session.createMapMessage();
                map.setString("EventType", eventType);
                map.setString("SessionID", sessionID);
                map.setString("EventData", msgData);
                publisher.send(map);
            }
        }
        catch (Exception e)
        {
            if (ic != null)
            {
                try
                {
                    ic.close();
                }
                catch (Exception e1){
                    logger.error("Error in sending jms msg: ", e1);
                }

            }

            closeConnection(connection);
            createConnection();
        }
    }




    private void closeConnection(Connection con)
    {
        try
        {
            if (con != null)
            {
                con.close();
            }
        }
        catch (JMSException jmse)
        {
            System.out.println("Could not close connection " + con + " exception was " + jmse);
            logger.error("Could not close jms connection :", jmse);
        }
    }

    public void closeConnection() {
        closeConnection(connection);
    }
}
