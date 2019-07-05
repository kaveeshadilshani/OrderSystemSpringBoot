package com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderParams {

    @Id
    private long id1;



    private int orderChannel;
    private String price;
    private String type;
    private String symbol;
    private String tenantCode;
    private String marketCode;
    private String exchange;
    private int side;
    private int orderMode;
    private String dealerID;

    public OrderParams(int orderChannel, String price, String type, String symbol, String tenantCode, String marketCode, String exchange, int side, int orderMode, String dealerID) {
        this.orderChannel = orderChannel;
        this.price = price;
        this.type = type;
        this.symbol = symbol;
        this.tenantCode = tenantCode;
        this.marketCode = marketCode;
        this.exchange = exchange;
        this.side = side;
        this.orderMode = orderMode;
        this.dealerID = dealerID;
    }

    public long getId1() {
        return id1;
    }

    public void setId1(long id1) {
        this.id1 = id1;
    }

    public int getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(int orderChannel) {
        this.orderChannel = orderChannel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public OrderParams( ){}
    public long getId() {
        return id1;
    }

    public void setId(long id) {
        this.id1 = id;
    }


    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(int orderMode) {
        this.orderMode = orderMode;
    }

    public String getDealerID() {
        return dealerID;
    }

    public void setDealerID(String dealerID) {
        this.dealerID = dealerID;
    }
}
