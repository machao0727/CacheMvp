package com.mc.uniteroute_refactor_mvp.net;

import android.content.Context;

import com.mc.uniteroute_refactor_mvp.mvp.model.response.Base;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.CarInfo;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.model;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MC on 2017/12/19.
 * 网络连接
 */

public class HttpManager {
    private static HttpManager Instance = null;
    private ApiService apiService;

    private HttpManager() {
        apiService = RetrofitManager.getInstance().getApiService();
    }

    public static HttpManager getInstance() {
        if (Instance == null) {
            Instance = new HttpManager();
        }
        return Instance;
    }


    /**
     * 车辆列表
     */
    public void getCarInfo(MCCallBack<List<CarInfo>> callBack, Context context) {
        HttpUtils.load("CarInfo", 60, context, apiService.getCarInfo())
                .compose(RxHelper.handleResult())
                .subscribe(callBack);
    }

    /**
     * 车型
     */
    public void getCarModel(MCCallBack<List<model>> callBack, Context context) {
        HttpUtils.load("getCarModel", 60, context, apiService.getmodels())
                .compose(RxHelper.handleResult())
                .subscribe(callBack);
    }
}
