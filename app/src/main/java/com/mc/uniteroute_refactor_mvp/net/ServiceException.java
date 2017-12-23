package com.mc.uniteroute_refactor_mvp.net;

/**
 * Created by MC on 2017/12/21.
 * 网络异常
 */

public class ServiceException extends Throwable {
    public ServiceException(String msg) {
        super(msg);
    }
}
