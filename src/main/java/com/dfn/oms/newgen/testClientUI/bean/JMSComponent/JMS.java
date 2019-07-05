package com.dfn.oms.newgen.testClientUI.bean.JMSComponent;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class JMS {

    @Id
    private long id2;

    private String jmsMessage;
    private static String exchange;

    public JMS( String jmsMessage) {
        this.jmsMessage = jmsMessage;
    }
    public JMS(){}

    public long getId2() {
        return id2;
    }

    public void setId2(long id2) {
        this.id2 = id2;
    }


    public String getJmsMessage() {
        return jmsMessage;
    }

    public void setJmsMessage(String jmsMessage) {
        this.jmsMessage = jmsMessage;
    }

    public long getId() {
        return id2;
    }

    public void setId(long id) {
        this.id2 = id;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        return "JMS{" +
                "id=" + id2 +
                ", jmsMessage='" + jmsMessage + '\'' +
                ", exchange='" + exchange + '\'' +
                '}';
    }

}
