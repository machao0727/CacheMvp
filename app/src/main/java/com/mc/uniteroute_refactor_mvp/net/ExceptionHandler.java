package com.mc.uniteroute_refactor_mvp.net;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

/**
 * Created by MC on 2017/12/21.
 * 异常处理
 */

public class ExceptionHandler {
    private static String errorMsg = "请求失败，请稍后重试";

    public static String handleException(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {//网络超时
            errorMsg = "网络连接异常";

        } else if (e instanceof ConnectException) { //均视为网络错误
            errorMsg = "网络连接异常";

        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //均视为解析错误
            errorMsg = "数据解析异常";
        } else if (e instanceof UnknownHostException) {
            errorMsg = "网络连接异常";
        } else if (e instanceof IllegalArgumentException) {
            errorMsg = "参数错误";
        } else if (e instanceof ServiceException) {
            errorMsg = "服务器错误";
        } else {//未知错误
            errorMsg = "未知错误，可能抛锚了吧~";
        }
        return errorMsg;
    }
}
