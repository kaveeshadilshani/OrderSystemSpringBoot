package com.dfn.oms.newgen.testClientUI.bean.ErrorCode;

public interface ErrorCodesI {
    public String getDescription();

    public int getId();

    public <T extends ErrorCodesI> T getErrorCode();
}
