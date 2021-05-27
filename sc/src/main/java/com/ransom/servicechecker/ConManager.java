package com.ransom.servicechecker;

import android.content.Context;

import javax.crypto.Cipher;

import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.connection.HttpRequest;
import connection.rxconnection.session.SessionRun;

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
            new SessionRun(context).setRun(((ResponseAccess) o).isAccess());
            if (!((ResponseAccess) o).isAccess()) {
                Runtime.getRuntime().exit(128);
//                listener.unAuthorized(null, null);
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
