package com.mc.uniteroute_refactor_mvp.net;

import com.mc.uniteroute_refactor_mvp.mvp.model.response.Base;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MC on 2017/12/21.
 * 结果预处理
 */

public class RxHelper {
    /**
     * Rx优雅处理服务器返回
     * 仅对正确结果进行处理,其余均视为服务器错误
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<Base<T>, T> handleResult() {
        return upstream -> upstream.flatMap(result -> {
                    if (result.getCode() == 200) {
                        return createData(result.getValue());
                    } else {
                        return Observable.error(new ServiceException("服务器错误"));
                    }
                }
        ).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private static <T> Observable<T> createData(final T t) {
        return Observable.create(subscriber -> {
            try {
                subscriber.onNext(t);
                subscriber.onComplete();
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });
    }
}
