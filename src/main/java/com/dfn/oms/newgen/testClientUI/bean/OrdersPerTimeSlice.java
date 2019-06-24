package com.dfn.oms.newgen.testClientUI.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class OrdersPerTimeSlice {
    @Id
    private long id2;

    private int orderPerSlice;
    private int timePeriod;
    private boolean GWClient;

    public long getId() {
        return id2;
    }

    public void setId(long id2) {
        this.id2 = id2;
    }

    public int getOrderPerSlice() {
        return orderPerSlice;
    }

    public void setOrderPerSlice(int orderPerSlice) {
        this.orderPerSlice = orderPerSlice;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public boolean isGWClient() {
        return GWClient;
    }

    public void setGWClient(boolean GWClient) {
        this.GWClient = GWClient;
    }

    @Override
    public String toString() {
        return "OrdersPerTimeSlice{" +
                "id=" + id2 +
                ", orderPerSlice=" + orderPerSlice +
                ", timePeriod=" + timePeriod +
                ", GWClient=" + GWClient +
                '}';
    }
}
