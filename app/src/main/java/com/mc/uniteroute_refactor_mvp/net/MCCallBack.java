package com.mc.uniteroute_refactor_mvp.net;


import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by MC on 2017/12/21.
 * 结果回调
 */

public abstract class MCCallBack<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {
        DisposableUtils.getInstance().addDisposable(d);
    }

    @Override
    public void onNext(T value) {
        _onNext(value);
    }

    @Override
    public void onError(Throwable e) {
        _onError(ExceptionHandler.handleException(e));
    }

    @Override
    public void onComplete() {

    }

    public abstract void _onNext(T value);

    public abstract void _onError(String e);
}
