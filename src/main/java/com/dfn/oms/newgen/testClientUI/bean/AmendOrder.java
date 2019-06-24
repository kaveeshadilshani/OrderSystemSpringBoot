package com.dfn.oms.newgen.testClientUI.bean;

public class AmendOrder {
    private String clOrdID;
    private int orderQty;
    private String price;

    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "AmendOrder{" +
                "clOrdID='" + clOrdID + '\'' +
                ", orderQty=" + orderQty +
                ", price='" + price + '\'' +
                '}';
    }
}


