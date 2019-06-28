package com.dfn.oms.newgen.testClientUI.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static com.dfn.oms.newgen.testClientUI.OrderController.responseList;


@ClientEndpoint

public class WebSocketClientEndPoint {
    Session userSession = null;
  // private MessageHandler messageHandler;
    public static int responseCount = 0;
    private URI endpointURI;
    private ObjectMapper objectMapper;
    private static WebSocketClientEndPoint webSocketClientEndPoint;
    private  static Map<String, ResponseBean> commonResponseMap;

    public WebSocketClientEndPoint(){}
    public WebSocketClientEndPoint(URI endpointURI) {
        commonResponseMap = new HashMap<>();
        objectMapper = new ObjectMapper();
        try {
//            String isClient=System.getProperties().get("DFN_STAT_CLIENT")+"";
//            if(isClient!=null && isClient.trim().equals("1")){
//            responseCount=0;
            this.endpointURI = endpointURI;
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();

//            System.getProperties().put("javax.net.debug", "all"); //usefull to understand problems
//
//            System.getProperties().put(SSLContextConfigurator.KEY_STORE_FILE, your_new_keystore_path);
//
//            System.getProperties().put(SSLContextConfigurator.TRUST_STORE_FILE, your_new_keystore_path);
//
//            System.getProperties().put(SSLContextConfigurator.KEY_STORE_PASSWORD, the_password_you_entered);
//
//            System.getProperties().put(SSLContextConfigurator.TRUST_STORE_PASSWORD, the_password_you_enterede);
//
//            ClientManager client = ClientManager.createClient();
//
//            SslEngineConfigurator sslEngineConfigurator = new SslEngineConfigurator(new SslContextConfigurator());
//
//            sslEngineConfigurator.setHostVerificationEnabled(false); //skip host verification
//
//            client.getProperties().put(ClientProperties.SSL_ENGINE_CONFIGURATOR, sslEngineConfigurator);


            container.connectToServer(this, endpointURI);
//            }
        } catch (Exception e) {
            System.out.println("\n client container create failed");
            throw new RuntimeException(e);
        }
    }

    /**
     * Callback hook for Connection open events.
     *
     * @param userSession the userSession which is opened.
     */
    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("opening web socket");
        this.userSession = userSession;
    }

    /**
     * Callback hook for Connection close events.
     *
     * @param userSession the userSession which is getting closed.
     * @param reason      the reason for connection close
     */
    @OnClose
    public void onClose(Session userSession, CloseReason reason) {
        System.out.println("closing web socket:" + reason.getReasonPhrase() + "," + reason.getCloseCode());
        this.userSession = null;
//      System.exit(1);
    }

    /**
     * Callback hook for Message Events. This method will be invoked when a client send a message.
     *
     * @param message The text message
     */
    @OnMessage
    public void onMessage(String message) {
        responseCount++;
        responseList.add(responseCount + message);
        System.out.println("On Message:" + message + " response count:" + responseCount);
        ResponseBean<LoginResDataBean> responseBean;
        ObjectMapper map = new ObjectMapper();
        JSONHandler json = new JSONHandler();
        try {
            responseBean = map.readValue(message, new TypeReference<ResponseBean<LoginResDataBean>>(){});
            commonResponseMap.put(responseBean.getCommonHeader().getUnqReqId(), responseBean);
        } catch (IOException e) {
//            e.printStackTrace();
        }


        // System.out.println(" response count:" + responseCount);
//        if (messageHandler != null) {
//            messageHandler.handleMessage(message);
//        }

    }

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("\n OnError message:" + t.getMessage());
        t.printStackTrace();
    }

    /**
     * register message handler
     *
     * @param msgHandler
     */
//    public void addMessageHandler(MessageHandler msgHandler) {
//        messageHandler = msgHandler;
//    }
    /**
     * Send a message.
     *
     * @param message
     */


    public void sendMessage1(String message) {
        try {
            /*
             ByteBuffer buf = ByteBuffer.allocate(message.length()*2);
            CharBuffer cbuf = buf.asCharBuffer();
            cbuf.put(message);
            this.userSession.getAsyncRemote().sendBinary(buf);
             */
            if (userSession == null || !userSession.isOpen()) {
                ContainerProvider.getWebSocketContainer().connectToServer(this, endpointURI);
            }
            userSession.getAsyncRemote().sendText(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void close() {
        if (userSession != null) {
            try {
                userSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Message handler.
     *
     * @author Jiji_Sasidharan
     */
    public static class MessageHandler {

//        public void handleMessage(String message);
public ResponseBean getResponseDetails(WebSocketClientEndPoint webSocketClientEndPoint, String requestId, int messageType) {
    if (messageType != 1) {

        ResponseBean responseBean;
        while (true) {
            responseBean = webSocketClientEndPoint.getCommonResponseMap().get(requestId);
            if (responseBean != null) {
                break;
            }
        }
        if (responseBean.getCommonHeader().getMsgTyp() != messageType) {
            webSocketClientEndPoint.getCommonResponseMap().remove(requestId);
            return getResponseDetails(webSocketClientEndPoint, requestId, messageType);
        }

        return responseBean;
    } else {
        return handleResponseLogin(webSocketClientEndPoint, requestId);
    }
}
        private ResponseBean handleResponseLogin(WebSocketClientEndPoint webSocketDirecter, String requestId) {
            long defaultTimeout = System.currentTimeMillis();
            ResponseBean responseBean = null;
            while (responseBean == null) {
                responseBean = webSocketDirecter.getCommonResponseMap().get(requestId);
            }
            return responseBean;
        }

    }

    public void sendMessage(RequestBean requestBean) {
        if (userSession == null || !userSession.isOpen()) {
            try {
                ContainerProvider.getWebSocketContainer().connectToServer(this, endpointURI);
            } catch (Exception e) {
                System.out.println("Error in sending request bean"+ e);
            }
        }
        directMessage(requestBean);



    }

    private void directMessage(RequestBean requestBean) {
        try {
            String message = objectMapper.writeValueAsString(requestBean);
            userSession.getAsyncRemote().sendText(message);
            System.out.println("Message Sent " + message);
        } catch (JsonProcessingException e) {
            System.out.println("JsonProcessingException ," + e.getMessage());
        }
    }

    public static WebSocketClientEndPoint getInstance() {
        if (webSocketClientEndPoint == null)
            webSocketClientEndPoint = new WebSocketClientEndPoint();
        return webSocketClientEndPoint;
    }


    public Map<String, ResponseBean> getCommonResponseMap() {
        return commonResponseMap;
    }


}



