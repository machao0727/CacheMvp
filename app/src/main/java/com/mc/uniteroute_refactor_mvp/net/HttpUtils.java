package com.mc.uniteroute_refactor_mvp.net;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.mc.uniteroute_refactor_mvp.mvp.model.response.Base;

import java.io.Serializable;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by MC on 2017/12/21.
 * 网络连接
 */

public class HttpUtils {

    /**
     * 不进行缓存
     *
     * @param observable 被观察者
     * @param <T>        泛型
     * @return result
     */
    public static <T> Observable<T> load(Observable<T> observable) {
        return setCache(null, -1, observable, null);
    }


    /**
     * 进行缓存
     *
     * @param cacheKey   缓存key
     * @param cacheTime  缓存时间 int 秒
     * @param context    context
     * @param observable 被观察者
     * @param <T>        发型
     * @return result
     */
    public static <T> Observable<T> load(String cacheKey, int cacheTime, Context context, Observable<T> observable) {
        return setCache(cacheKey, cacheTime, observable, context);
    }

    private static <T> Observable<T> setCache(String cacheKey, int cacheTime, Observable<T> observable, Context context) {

        Observable<T> fromCache = null;
        if (cacheKey != null) {//缓存key不为空证明需要读取缓存
            fromCache = Observable.create(e -> {
                T Cache = (T) ACache.get(context).getAsObject(cacheKey);
                if (Cache != null) {//缓存时间不为空，数据未过期
                    e.onNext(Cache);
                } else {//为空就不发射数据
                    e.onComplete();
                }
            });
        }
        observable = observable.map(new Function<T, T>() {
            @Override
            public T apply(T t) throws Exception {
                try {//这里需要捕获异常，防止返回数据格式错误
                    Base baseResp = (Base) t;
                    if (baseResp.getCode() == 200) {//返回正确的数据才进行缓存
                        ACache.get(context).put(cacheKey, (Serializable) t, cacheTime);//缓存过期时间
                    }
                } catch (Exception e) {
                    Log.e(this.getClass().toString(), ">>>>>>>>>>>>数据结构异常");
                }
                return t;
            }
        });
        if (cacheKey == null) {//不缓存，直接返回网络observable
            return observable;
        } else {
            return Observable.concat(fromCache, observable);
        }
    }
}
