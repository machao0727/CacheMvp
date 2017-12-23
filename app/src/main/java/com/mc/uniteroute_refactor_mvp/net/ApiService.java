package com.mc.uniteroute_refactor_mvp.net;

import com.mc.uniteroute_refactor_mvp.mvp.model.response.Base;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.CarInfo;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by MC on 2017/12/19.
 */

public interface ApiService {


    //资讯分类查询
    @Headers({"Content-Type:application/json", "Accept:application/json"})
    @GET("http://oilchooser.fuchs.com.cn:90/fuchs/level/manufacturers/getManufacturers?brandId=%25e6%2596%25af%25e6%259f%25af%25e8%25be%25be")
    Observable<Base<List<CarInfo>>> getCarInfo();

    //资讯分类查询
    @Headers({"Content-Type:application/json", "Accept:application/json"})
    @GET("http://oilchooser.fuchs.com.cn:90/fuchs/level/model/getModels?brandId=%25E6%2596%25AF%25E6%259F%25AF%25E8%25BE%25BE&manufacturersId=%25E5%25A4%25A7%25E4%25BC%2597%25E6%25B1%25BD%25E8%25BD%25A6")
    Observable<Base<List<model>>> getmodels();
}
