package com.ransom.servicechecker;

import android.content.Context;

import connection.rxconnection.connection.HttpMethod;
import connection.rxconnection.connection.HttpRequest;

public class ConAccess extends HttpRequest<Object, ResponseAccess> {
    public ConAccess(Context context) {
        super(context, "https://drive.google.com/uc?export=download&id=1Wh43R1h_xV6vW6U7iWhlMQu5F-eyXQgj"
                /*"https://drive.google.com/uc?export=download&id=1TMR6fad8Z3rHsmfpeEKQv1U31YVHMspF"*/, HttpMethod.GET);
    }
}
