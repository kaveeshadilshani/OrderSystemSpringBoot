package com.dfn.oms.newgen.testClientUI.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ip;
    private int port;
    private int endpoint;
    private int noOfOrders;

    private int orderQty;

    public User(){}

    public User(String ip, int port,int endpoint, int noOfOrders, int orderQty) {
        this.ip = ip;
        this.port = port;
        this.endpoint = endpoint;
        this.noOfOrders = noOfOrders;
        this.orderQty = orderQty;
    }

    public long getId() {
        return id;
    }

    public int getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(int endpoint) {
        this.endpoint = endpoint;
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

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", endpoint=" + endpoint +
                ", noOfOrders=" + noOfOrders +
                ", orderQty=" + orderQty +
                '}';
    }
}
