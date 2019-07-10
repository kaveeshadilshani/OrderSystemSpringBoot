package com.dfn.oms.newgen.testClientUI.bean;

//@Entity
public class GatewayUser {

    private String ip;
    private int port;
    private int endpoint;
    private int repeatCount;
    private boolean sendFileContent;
    private boolean isTimeBounded;
    private boolean isRated;
//    private boolean isCountEnabled;
    private int requestsPerSec;
    private int timeConstraintMin;
    private int msgCount;

    public GatewayUser(String ip, int port, int endpoint, int repeatCount, boolean sendFileContent, int requestsPerSec
            , boolean isTimeBounded, boolean isRated, int timeConstraintMin, int msgCount){

        this.ip = ip;
        this.port = port;
        this.endpoint = endpoint;
        this.repeatCount = repeatCount;
        this.sendFileContent = sendFileContent;
        this.isTimeBounded = isTimeBounded;
        this.isRated = isRated;
//        this.isCountEnabled = isCountEnabled;
        this.timeConstraintMin = timeConstraintMin;
        this.requestsPerSec = requestsPerSec;
        this.msgCount = msgCount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(int endpoint) {
        this.endpoint = endpoint;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public int getRequestsPerSec() {
        return requestsPerSec;
    }

    public void setRequestsPerSec(int requestsPerSec) {
        this.requestsPerSec = requestsPerSec;
    }


    public boolean isSendFileContent() {
        return sendFileContent;
    }

    public void setSendFileContent(boolean sendFileContent) {
        this.sendFileContent = sendFileContent;
    }

    public boolean isTimeBounded() {
        return isTimeBounded;
    }

    public void setTimeBounded(boolean timeBounded) {
        isTimeBounded = timeBounded;
    }

    public boolean isRated() {
        return isRated;
    }

    public void setRated(boolean rated) {
        isRated = rated;
    }
//
//    public boolean isCountEnabled() {
//        return isCountEnabled;
//    }
//
//    public void setCountEnabled(boolean countEnabled) {
//        isCountEnabled = countEnabled;
//    }

    public int getMsgCount() {
        return msgCount;
    }

    public void setMsgCount(int msgCount) {
        this.msgCount = msgCount;
    }

    public int getTimeConstraintMin() {
        return timeConstraintMin;
    }

    public void setTimeConstraintMin(int timeConstraintMin) {
        this.timeConstraintMin = timeConstraintMin;
    }


}
