package com.mc.uniteroute_refactor_mvp.net;

import android.content.Context;

import com.mc.uniteroute_refactor_mvp.utils.NetworkUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MC on 2017/12/19.
 * Retrofit管理类
 */

public class RetrofitManager {
    private static String BASE_URL = "http://192.168.0.228:8084/api/";
    private static long DEFAULT_TIMEOUT = 10L;
    private Context mContext;
    private static RetrofitManager retrofitManager = null;
    private ApiService apiService;
    private Retrofit retrofit;

    public ApiService getApiService() {
        return apiService;
    }

    public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    private RetrofitManager() {

    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }
        return retrofitManager;
    }

    /**
     * 网络工具初始化
     * Application中调用
     */
    public void init(Context context) {
        mContext = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createOkHttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private OkHttpClient createOkHttpClient(Context context) {
        //设置缓存路径
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        //设置缓存 10M
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE))
                .addNetworkInterceptor(getNetworkInterceptor())
//                .addInterceptor(addCacheInterceptor())
//                .cache(cache)
                .build();
        return client;
    }

    /**
     * 添加缓存，仅对get有效
     *
     * @return 拦截器
     */
    private Interceptor addCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //请求第一步拦截request
                Request request = chain.request();
                if (!NetworkUtil.hasConnection(mContext)) {
                    //如果没有网络，就从缓存中读数据
                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                }
                Response response;
                response = chain.proceed(request);
                //第二步设置response
                if (NetworkUtil.hasConnection(mContext)) {
                    // 有网络时 设置缓存超时时间0个小时 ,意思就是不读取缓存数据,只对get有用,post没有缓冲
                    //移除服务器自带返回的header防止与自己设置的冲突
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + 0)
                            .removeHeader("Pragma")
                            .removeHeader("Cache-Control")
                            .build();
                } else {
                    // 无网络时，设置超时为4周  只对get有用,post没有缓冲
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 28)
                            .removeHeader("Pragma")
                            .removeHeader("Cache-Control")
                            .build();
                }
                return response;
            }
        };
    }

    private Interceptor getNetworkInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request = request.newBuilder().header("Authorization", "").build();
                return chain.proceed(request);
            }
        };
    }
}
