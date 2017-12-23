package com.mc.uniteroute_refactor_mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mc.uniteroute_refactor_mvp.base.annotation.MCActivityFeature;
import com.mc.uniteroute_refactor_mvp.net.DisposableUtils;
import com.mc.uniteroute_refactor_mvp.net.HttpManager;

import butterknife.ButterKnife;

/**
 * Created by MC on 2017/12/19.
 * 基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MCActivityFeature activityFeature = BaseActivity.this.getClass().getAnnotation(MCActivityFeature.class);
        setContentView(activityFeature.layout());
        ButterKnife.bind(this);
        initPresenter();
        initData();
        initView();
    }

    /**
     * 初始化presenter
     */
    protected abstract void initPresenter();


    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化视图
     */
    public abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DisposableUtils.getInstance().destroy();
    }
}
