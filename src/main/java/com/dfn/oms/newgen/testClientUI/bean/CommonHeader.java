package com.dfn.oms.newgen.testClientUI.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonHeader {
    private int msgTyp;
    private String tenantCode;
    private String sesnId;
    private String commVer;
    private int loginId;
    private int channel;
    private String clientIp;
    private String unqReqId;
    private int routeId;

    public void setCommVer(String commVer) {
        this.commVer = commVer;
    }

    public void setMsgTyp(int msgTyp) {
        this.msgTyp = msgTyp;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public void setSesnId(String sesnId) {
        this.sesnId = sesnId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public void setUnqReqId(String unqReqId) {
        this.unqReqId = unqReqId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getMsgTyp() {
        return msgTyp;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public String getSesnId() {
        return sesnId;
    }

    public int getLoginId() {
        return loginId;
    }

    public int getChannel() {
        return channel;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getUnqReqId() {
        return unqReqId;
    }

    public int getRouteId() {
        return routeId;
    }

    public String getCommVer() {
        return commVer;
    }
}
