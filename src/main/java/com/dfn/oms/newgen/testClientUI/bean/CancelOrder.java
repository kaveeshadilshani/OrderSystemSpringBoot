package com.dfn.oms.newgen.testClientUI.bean;

public class CancelOrder {
    private String clOrdID;

    public String getClOrdID() {
        return clOrdID;
    }

    public void setClOrdID(String clOrdID) {
        this.clOrdID = clOrdID;
    }

    @Override
    public String toString() {
        return "CancelOrder{" +
                "clOrdID='" + clOrdID + '\'' +
                '}';
    }
}
