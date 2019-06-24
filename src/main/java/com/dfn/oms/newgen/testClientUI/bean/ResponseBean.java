package com.dfn.oms.newgen.testClientUI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
public class ResponseBean<T extends ResData> {
    @JsonProperty("HED")
    private CommonHeader commonHeader;
    @JsonProperty("DAT")
    private T commonData;

    public void setCommonData(T commonData) {
        this.commonData = commonData;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }


    public T getCommonData() {
        return commonData;
    }

    public CommonHeader getCommonHeader() {
        return commonHeader;
    }

}
