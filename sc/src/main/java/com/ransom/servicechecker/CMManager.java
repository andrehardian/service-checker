package com.ransom.servicechecker;

import connection.rxconnection.connection.BaseServiceResponse;
import connection.rxconnection.connection.ConnectionManager;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CMManager extends ConnectionManager {
    @Override
    protected void getSession() {
        Observable.create(new ConAccess(getContext()))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.newThread())
                .subscribe((new BaseServiceResponse(getConnectionListener()))
                        .setCallBackSubscriber(this));
    }
}
