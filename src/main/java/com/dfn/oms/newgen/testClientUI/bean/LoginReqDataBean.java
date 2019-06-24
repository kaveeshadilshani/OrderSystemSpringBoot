package com.dfn.oms.newgen.testClientUI.bean;

public class LoginReqDataBean implements ReqData {
    private String lgnNme;
    private String pwd;

    public void setLgnNme(String lgnNme) {
        this.lgnNme = lgnNme;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLgnNme() {
        return lgnNme;
    }

    public String getPwd() {
        return pwd;
    }
}
