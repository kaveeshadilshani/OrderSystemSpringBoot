package com.hellokoding.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderRequestBean extends OMSTnsAbstractMessage {

    public OrderRequestBean() {

    }

    public OrderRequestBean(Order order) {
        this.order = order;
    }

    @JsonProperty("DAT")
    private Order order;
    //@JsonIgnore
    //private transient ExchangeMessage exchangeMessage;


    private Order originalOrder;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @JsonIgnore
    public Order getOriginalOrder() {
        return originalOrder;
    }

    @JsonIgnore
    public void setOriginalOrder(Order originalOrder) {
        this.originalOrder = originalOrder;
    }

//    @JsonIgnore
//    public ExchangeMessage getExchangeMessage() {
//        return exchangeMessage;
//    }
//
//    @JsonIgnore
//    public void setExchangeMessage(ExchangeMessage exchangeMessage) {
//        this.exchangeMessage = exchangeMessage;
//    }

}
