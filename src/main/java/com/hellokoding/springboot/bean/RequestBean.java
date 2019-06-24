package com.hellokoding.springboot.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
public class RequestBean<T extends ReqData> {
    @JsonProperty(value = "HED")
    private CommonHeader commonHeader;
    @JsonProperty(value = "DAT")
    private T dataBean;


    public T getDataBean() {
        return dataBean;
    }

    public void setDataBean(T loginDataBean) {
        this.dataBean = loginDataBean;
    }

    public CommonHeader getCommonHeader() {
        return commonHeader;
    }

    public void setCommonHeader(CommonHeader commonHeader) {
        this.commonHeader = commonHeader;
    }
}
