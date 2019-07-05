package com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent;

import com.dfn.oms.newgen.testClientUI.bean.OMS.OMSTnsAbstractMessage;

import java.util.List;

public class OrderInquiryBean extends OMSTnsAbstractMessage {
    private long cliOrdId;
    private int customerId;
    private List<Order> orders;

    public long getCliOrdId() {
        return cliOrdId;
    }

    public void setCliOrdId(long cliOrdId) {
        this.cliOrdId = cliOrdId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
