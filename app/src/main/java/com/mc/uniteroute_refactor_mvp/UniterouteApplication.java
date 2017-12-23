package com.mc.uniteroute_refactor_mvp;

import android.app.Application;

import com.mc.uniteroute_refactor_mvp.net.RetrofitManager;

/**
 * Created by Administrator on 2017/12/19.
 */

public class UniterouteApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitManager.getInstance().init(this);
    }
}
