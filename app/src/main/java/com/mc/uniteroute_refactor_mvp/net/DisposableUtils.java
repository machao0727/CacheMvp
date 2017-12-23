package com.mc.uniteroute_refactor_mvp.net;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by MC on 2017/12/22.
 *
 */

public class DisposableUtils {
    private static DisposableUtils Instance = null;
    private CompositeDisposable disposable;

    private DisposableUtils() {
        disposable = new CompositeDisposable();
    }

    public static DisposableUtils getInstance() {
        if (Instance == null) {
            Instance = new DisposableUtils();
        }
        return Instance;
    }

    public void addDisposable(Disposable dis) {
        disposable.add(dis);
    }

    public void destroy() {
        disposable.clear();
    }
}
