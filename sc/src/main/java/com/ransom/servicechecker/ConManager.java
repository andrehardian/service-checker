package com.ransom.servicechecker;

import android.content.Context;

import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.connection.HttpRequest;
import connection.rxconnection.session.SessionLogin;

public class ConManager implements ConnectionListener {
    protected ConnectionListener listener;
    private Context context;

    public ConManager(Context context, ConnectionListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onSuccessWithData(Object o) {
        if (o instanceof ResponseAccess) {
            if (!((ResponseAccess) o).isAccess()) {
                listener.unAuthorized(null, null);
                return;
            }
        }
        listener.onSuccessWithData(o);
    }

    @Override
    public void onSuccessNull() {
        listener.onSuccessNull();
    }

    @Override
    public void onMessageSuccess(String s) {
        listener.onMessageSuccess(s);
    }

    @Override
    public void onError(Object o, HttpRequest httpRequest) {
        listener.onError(o, httpRequest);
    }

    @Override
    public void unAuthorized(HttpRequest httpRequest, String messageError) {
        listener.unAuthorized(httpRequest, messageError);
    }
}
