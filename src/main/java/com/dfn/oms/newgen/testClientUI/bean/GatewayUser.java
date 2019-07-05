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
    private int requestsPerSec;
    private int timeConstraintHour;
    private int timeConstraintMin;

    public GatewayUser(){}

    public GatewayUser(long id, String ip,int port, int endpoint,int repeatCount, boolean periodically,int requestsPerSec
            ,int timeConstraintHour, int timeConstraintMin){

        this.id = id;
        this.ip = ip;
        this.port = port;
        this.endpoint = endpoint;
        this.repeatCount = repeatCount;
        this.periodically = periodically;
        this.requestsPerSec = requestsPerSec;
        this.timeConstraintHour = timeConstraintHour;
        this.timeConstraintMin = timeConstraintMin;
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

    public int getRequestsPerSec() {
        return requestsPerSec;
    }

    public void setRequestsPerSec(int requestsPerSec) {
        this.requestsPerSec = requestsPerSec;
    }


    public int getTimeConstraintHour() {
        return timeConstraintHour;
    }

    public void setTimeConstraintHour(int timeConstraintHour) {
        this.timeConstraintHour = timeConstraintHour;
    }

    public int getTimeConstraintMin() {
        return timeConstraintMin;
    }

    public void setTimeConstraintMin(int timeConstraintMin) {
        this.timeConstraintMin = timeConstraintMin;
    }


}
