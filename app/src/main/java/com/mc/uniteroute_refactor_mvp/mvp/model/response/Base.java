package com.mc.uniteroute_refactor_mvp.mvp.model.response;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Base<T> implements Serializable{
    private String message;
    private  T value;
    private int code;
    private String redirect;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }
}
