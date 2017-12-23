package com.mc.uniteroute_refactor_mvp.mvp.presenter;

import android.content.Context;

import com.mc.uniteroute_refactor_mvp.mvp.controller.MainController;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.Base;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.CarInfo;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.model;
import com.mc.uniteroute_refactor_mvp.net.HttpManager;
import com.mc.uniteroute_refactor_mvp.net.MCCallBack;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public class MainPresenter implements MainController.Presenter {
    private MainController.View mRootView;

    public MainPresenter(MainController.View view) {
        mRootView = view;
    }

    @Override
    public void getCarInfoItem(Context context) {
        HttpManager.getInstance().getCarInfo(new MCCallBack<List<CarInfo>>() {
            @Override
            public void _onNext(List<CarInfo> value) {
                mRootView.showCarInfoItem(value);
            }

            @Override
            public void _onError(String e) {
                mRootView.showCarInfoError(e);
            }
        }, context);
    }

    @Override
    public void getCarInfoModel(Context context) {
        HttpManager.getInstance().getCarModel(new MCCallBack<List<model>>() {
            @Override
            public void _onNext(List<model> value) {
                mRootView.showCarModelItem(value);
            }

            @Override
            public void _onError(String e) {
                mRootView.showCarModelError(e);
            }
        }, context);
    }
}
