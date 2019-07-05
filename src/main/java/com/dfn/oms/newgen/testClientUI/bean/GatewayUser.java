package com.dfn.oms.newgen.testClientUI.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GatewayUser {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ip;
    private int port;
    private int endpoint;
    private int repeatCount;
    private boolean periodically;
    private int ordersPerSec;

    public GatewayUser(){}

    public GatewayUser(long id, String ip,int port, int endpoint,int repeatCount, boolean periodically,int ordersPerSec){

        this.id = id;
        this.ip = ip;
        this.port = port;
        this.endpoint = endpoint;
        this.repeatCount = repeatCount;
        this.periodically = periodically;
        this.ordersPerSec = ordersPerSec;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isPeriodically() {
        return periodically;
    }

    public void setPeriodically(boolean periodically) {
        this.periodically = periodically;
    }

    public int getOrdersPerSec() {
        return ordersPerSec;
    }

    public void setOrdersPerSec(int ordersPerSec) {
        this.ordersPerSec = ordersPerSec;
    }


}
