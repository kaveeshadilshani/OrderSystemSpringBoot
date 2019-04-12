package com.hellokoding.springboot.bean;

public class StatMonReqResBean  extends OMSTnsAbstractMessage {
    private int action;
    private String description;
    private JMSMessageRequest jmsMessageRequest;

    public class JMSMessageRequest{
        private String message;
        private String queueName;
        private int msgType;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getQueueName() {
            return queueName;
        }

        public void setQueueName(String queueName) {
            this.queueName = queueName;
        }

        public int getMsgType() {
            return msgType;
        }

        public void setMsgType(int msgType) {
            this.msgType = msgType;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public JMSMessageRequest getJmsMessageRequest() {
        return jmsMessageRequest;
    }

    public void setJmsMessageRequest(JMSMessageRequest jmsMessageRequest) {
        this.jmsMessageRequest = jmsMessageRequest;
    }
}