package com.ransom.servicechecker;

import android.content.Context;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConAccess extends HttpRequest<Object, ResponseAccess> {
    public ConAccess(Context context) {
        super(context,  "https://drive.google.com/uc?export=download&id=1tWjRZwfTdMok8a6lemaPes1ZZ1bA7S62", HttpMethod.GET);
    }
}
