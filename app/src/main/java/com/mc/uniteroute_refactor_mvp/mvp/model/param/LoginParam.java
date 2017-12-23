package com.mc.uniteroute_refactor_mvp.mvp.model.param;

/**
 * 登录的json参数
 * Created by MasterFan on 2016/7/15.
 */
public class LoginParam {

    private String loginName;
    private String pwd;
    private String client;
    private int    loginType;//登录类型(1：android、  2：ios、  3：Iosipad、  4：androidipad)

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getLoginType() {
        return loginType;
    }

    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }

    public LoginParam(String loginName, String pwd, String client, int loginType) {

        this.loginName = loginName;
        this.pwd = pwd;
        this.client = client;
        this.loginType = loginType;
    }

    public LoginParam() {

    }
}
