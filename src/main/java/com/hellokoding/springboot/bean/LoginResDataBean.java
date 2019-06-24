package com.hellokoding.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResDataBean implements ResData {
    private int isVatApplicable;
    private int userCategory;
    private int pwdExpDays;
    private int blockType;
    private float blockSpread;
    private int reportDepth;
    private String reportUrl;
    private String serverDate;
    private float maxPriceTolerance;
    private float maxOrderValue;
    private boolean updatePassword;
    private boolean autoUpdate;
    private String version;
    private int routeId;
    private int usrId;
    private int authSts;
    private String lgnExpDte;
    private int dlrId;
    private String mubNo;
    private int failAtmps;
    private int instId;
    private int l2AuthTyp;
    private String prcUsr;
    private String cusNme;
    private int clAccType;
    private String prefLang;
    private String lgnAls;
    private String cntryCode;
    private String brkId;
    private String ssoToken;
    private int u01CustomerId;
    private List entitlements;

    public void setEntitlements(List entitlements) {
        this.entitlements = entitlements;
    }

    public void setIsVatApplicable(int isVatApplicable) {
        this.isVatApplicable = isVatApplicable;
    }

    public void setUserCategory(int userCategory) {
        this.userCategory = userCategory;
    }

    public void setPwdExpDays(int pwdExpDays) {
        this.pwdExpDays = pwdExpDays;
    }

    public void setSsoToken(String ssoToken) {
        this.ssoToken = ssoToken;
    }

    public void setBlockType(int blockType) {
        this.blockType = blockType;
    }

    public void setBlockSpread(float blockSpread) {
        this.blockSpread = blockSpread;
    }

    public void setReportDepth(int reportDepth) {
        this.reportDepth = reportDepth;
    }

    public void setReportUrl(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    public void setServerDate(String serverDate) {
        this.serverDate = serverDate;
    }

    public void setMaxPriceTolerance(float maxPriceTolerance) {
        this.maxPriceTolerance = maxPriceTolerance;
    }

    public void setMaxOrderValue(float maxOrderValue) {
        this.maxOrderValue = maxOrderValue;
    }

    public void setUpdatePassword(boolean updatePassword) {
        this.updatePassword = updatePassword;
    }

    public void setAutoUpdate(boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    public void setAuthSts(int authSts) {
        this.authSts = authSts;
    }

    public void setLgnExpDte(String lgnExpDte) {
        this.lgnExpDte = lgnExpDte;
    }

    public void setDlrId(int dlrId) {
        this.dlrId = dlrId;
    }

    public void setMubNo(String mubNo) {
        this.mubNo = mubNo;
    }

    public void setFailAtmps(int failAtmps) {
        this.failAtmps = failAtmps;
    }

    public void setInstId(int instId) {
        this.instId = instId;
    }

    public int getIsVatApplicable() {
        return isVatApplicable;
    }

    public int getUserCategory() {
        return userCategory;
    }

    public int getPwdExpDays() {
        return pwdExpDays;
    }

    public int getBlockType() {
        return blockType;
    }

    public float getBlockSpread() {
        return blockSpread;
    }

    public int getReportDepth() {
        return reportDepth;
    }

    public String getSsoToken() {
        return ssoToken;
    }

    public String getReportUrl() {
        return reportUrl;
    }

    public String getServerDate() {
        return serverDate;
    }

    public float getMaxPriceTolerance() {
        return maxPriceTolerance;
    }

    public float getMaxOrderValue() {
        return maxOrderValue;
    }

    public boolean isUpdatePassword() {
        return updatePassword;
    }

    public boolean isAutoUpdate() {
        return autoUpdate;
    }

    public String getVersion() {
        return version;
    }

    public int getRouteId() {
        return routeId;
    }

    public int getUsrId() {
        return usrId;
    }

    public int getAuthSts() {
        return authSts;
    }

    public String getLgnExpDte() {
        return lgnExpDte;
    }

    public int getDlrId() {
        return dlrId;
    }

    public String getMubNo() {
        return mubNo;
    }

    public int getFailAtmps() {
        return failAtmps;
    }

    public int getInstId() {
        return instId;
    }

    public int getL2AuthTyp() {
        return l2AuthTyp;
    }

    public String getPrcUsr() {
        return prcUsr;
    }

    public String getCusNme() {
        return cusNme;
    }

    public int getClAccType() {
        return clAccType;
    }

    public String getPrefLang() {
        return prefLang;
    }

    public String getLgnAls() {
        return lgnAls;
    }

    public String getCntryCode() {
        return cntryCode;
    }

    public String getBrkId() {
        return brkId;
    }

    public int getU01CustomerId() {
        return u01CustomerId;
    }


    public List getEntitlements() {
        return entitlements;
    }

    public void setL2AuthTyp(int l2AuthTyp) {
        this.l2AuthTyp = l2AuthTyp;
    }

    public void setPrcUsr(String prcUsr) {
        this.prcUsr = prcUsr;
    }

    public void setCusNme(String cusNme) {
        this.cusNme = cusNme;
    }

    public void setClAccType(int clAccType) {
        this.clAccType = clAccType;
    }

    public void setPrefLang(String prefLang) {
        this.prefLang = prefLang;
    }

    public void setLgnAls(String lgnAls) {
        this.lgnAls = lgnAls;
    }

    public void setCntryCode(String cntryCode) {
        this.cntryCode = cntryCode;
    }

    public void setBrkId(String brkId) {
        this.brkId = brkId;
    }

    public void setU01CustomerId(int u01CustomerId) {
        this.u01CustomerId = u01CustomerId;
    }

}
