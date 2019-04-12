package com.hellokoding.springboot.bean;

public class WebSocketRunnerSetting {
    private String ip = "127.0.0.1";
    //        private String ip 2
    // = "192.168.16.56";
    // private String ip = "192.168.14.215";
//        private String ip = "192.168.16.133";
    private int port = 80;
    public static boolean isGWClient = false;
    public static int numOfEndPoints = 1;

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

    public boolean isGWClient() {
        return isGWClient;
    }

    public void setGWClient(boolean isGWClient) {
        this.isGWClient = isGWClient;
    }

    public int getNumOfEndPoints() {
        return numOfEndPoints;
    }

    public void setNumOfEndPoints(int numOfEndPoints) {
        this.numOfEndPoints = numOfEndPoints;

    }

}
