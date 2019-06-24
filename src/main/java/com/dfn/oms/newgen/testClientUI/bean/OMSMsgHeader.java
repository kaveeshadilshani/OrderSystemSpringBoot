package com.dfn.oms.newgen.testClientUI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OMSMsgHeader {
    @JsonProperty(value = "msgTyp")
    private int requestType;
    private String tenantCode = OMSConst.DEFAULT_TENANCY_CODE; //to support multi tenancy  ,todo populate this from session for none-login requests
    @JsonProperty(value = "sesnId")
    private String sessionID;
    @JsonProperty("loginId")
    private int loginID;
    //    private transient String description;
    private int channel = -1;
    @JsonProperty("clientIp")
    private String clientIP;
    private String commVer;
    @JsonProperty("unqReqId")
    private String unqReqId;//unique ID for each reqeust
    @JsonProperty("routeId")
    private String routeId;

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

   /* @JsonIgnore
    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public void setDescription(String description) {
        this.description = description;
    }*/

    public OMSMsgHeader() {
        //default header for JSON parsing
    }

    public OMSMsgHeader(OMSMsgHeader header) {
        requestType = header.getRequestType();
        tenantCode = header.getTenantCode();
        sessionID = header.getSessionID();
        loginID = header.getLoginID();
        channel = header.getChannel();
        clientIP = header.getClientIP();
        commVer = header.getCommVer();
        unqReqId = header.getUnqReqId();
    }

    public OMSMsgHeader copyDeep() {
        OMSMsgHeader omsMsgHeader = new OMSMsgHeader(this);
        return omsMsgHeader;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getClientIP() {
        return clientIP;
    }

    public void setClientIP(String clientIP) {
        this.clientIP = clientIP;
    }

    public String getCommVer() {
        return commVer;
    }

    public void setCommVer(String commVer) {
        this.commVer = commVer;
    }

    public String getUnqReqId() {
        return unqReqId;
    }

    public void setUnqReqId(String unqReqId) {
        this.unqReqId = unqReqId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
