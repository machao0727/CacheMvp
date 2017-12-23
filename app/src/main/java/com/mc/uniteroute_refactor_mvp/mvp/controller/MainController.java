package com.mc.uniteroute_refactor_mvp.mvp.controller;

import android.content.Context;

import com.mc.uniteroute_refactor_mvp.mvp.model.response.CarInfo;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.model;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public interface MainController {
    interface View {
        /**
         * 展示车辆列表
         * @param carInfos
         */
        void showCarInfoItem(List<CarInfo> carInfos);

        /**
         * 错误
         * @param throwable
         */
        void showCarInfoError(String throwable);

        /**
         * 展示车型
         * @param models
         */
        void showCarModelItem(List<model> models);

        /**
         * 错误
         * @param throwable
         */
        void showCarModelError(String throwable);
    }

    interface Presenter {
        /**
         * 获取车辆信息
         * @param context
         */
        void getCarInfoItem(Context context);

        /**
         * 获取车型信息
         * @param context
         */
        void getCarInfoModel(Context context);
    }
}
