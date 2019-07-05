package com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent;

import com.dfn.oms.newgen.testClientUI.bean.OMS.OMSConst;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order  implements Serializable, Cloneable {
    private String unqReqId = "";
    private double price = 0;
    private String tenantCode;
    private int orderMode = OMSConst.ORDER_MODE_NORMAL;

    @JsonProperty(value = "clOrdId")
    private String clOrdID;

    @JsonProperty(value = "orgClOrdId")
    private String origClOrdID;

    @JsonProperty(value = "tradingAccId")
    private int tradingAccountID;

    @JsonProperty(value = "ordTyp")
    private char type;

    @JsonProperty(value = "ordQty")
    private long quantity = 0;

    @JsonProperty(value = "cusId")
    private long customerID;

    @JsonProperty(value = "ordSide")
    private int side;

    @JsonProperty(value = "exg")
    private String exchange;

    private int cashAcntID;

    private int execBrokerID;

    private String symbol;

    private String marketCode;

    @JsonProperty(value = "tif")
    private int tIF = FIX.T59_DAY;

    @JsonProperty(value = "instruTyp")
    private int priceInstType;

    private String dealerID;

    private int action;//order action from client (i.e. new,change,cancel)

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
    public int getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(int orderMode) {
        this.orderMode = orderMode;
    }
    public void setType(char type) {
        this.type = type;
    }
    public char getType() {
        return type;
    }
    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;

    }
    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public int getCashAcntID() {
        return cashAcntID;
    }

    public void setCashAcntID(int cashAcntID) {
        this.cashAcntID = cashAcntID;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public int getTradingAccountID() {
        return tradingAccountID;
    }

    public void setTradingAccountID(int tradingAccountID) {
        this.tradingAccountID = tradingAccountID;
    }

    public int getExecBrokerID() {
        return execBrokerID;
    }

    public void setExecBrokerID(int execBrokerID) {
        this.execBrokerID = execBrokerID;
    }

    public String getMarketCode() {
        return marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    @JsonIgnore
    public int getAction() {
        return action;
    }

    @JsonIgnore
    public void setAction(int action) {
        this.action = action;
    }

    public int getTIF() {
        return tIF;
    }

    public void setTIF(int tIF) {
        this.tIF = tIF;
    }

    public int getPriceInstType() {
        return priceInstType;
    }

    public void setPriceInstType(int priceInstType) {
        this.priceInstType = priceInstType;
    }

    public String getDealerID() {
        return dealerID;
    }

    public void setDealerID(String dealerID) {
        this.dealerID = dealerID;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;

    }
    public String getUnqReqId() {
        return unqReqId;
    }

    public void setUnqReqId(String unqReqId) {
        this.unqReqId = unqReqId;
    }

    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }

    public String getOrigClOrdID() {
        return origClOrdID;
    }

    public void setOrigClOrdID(String origClOrdID) {
        this.origClOrdID = origClOrdID;
    }

}
