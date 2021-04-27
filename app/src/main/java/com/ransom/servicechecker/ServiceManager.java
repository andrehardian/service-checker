package com.ransom.servicechecker;

import android.content.Context;

import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.connection.ConnectionManager;
import connection.rxconnection.connection.HttpRequest;

/**
 * Created by AndreHF on 11/14/2017.
 */

public class ServiceManager extends ConnectionManager implements ConnectionListener {
    private ConManager conManager;

    @Override
    public ConnectionManager setContext(Context context) {
        conManager = new ConManager(context, this);
        return super.setContext(context);
    }

    @Override
    public ConnectionManager setConnectionListener(ConnectionListener connectionListener) {
        return super.setConnectionListener(conManager);
    }

    public void check() {
        subscribe(new ConAccess(getContext()).setLogInfoRequestResponse(true));
    }

    @Override
    public void onSuccessWithData(Object o) {

    }

    @Override
    public void onSuccessNull() {

    }

    @Override
    public void onMessageSuccess(String s) {

    }

    @Override
    public void onError(Object o, HttpRequest httpRequest) {

    }

    @Override
    public void unAuthorized(HttpRequest httpRequest, String messageError) {

    }
}
