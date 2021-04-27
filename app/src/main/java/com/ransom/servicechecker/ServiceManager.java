package com.ransom.servicechecker;

import connection.rxconnection.connection.ConnectionManager;

/**
 * Created by AndreHF on 11/14/2017.
 */

public class ServiceManager extends ConnectionManager {
    public void check() {
        subscribe(new ConAccess(getContext()).setLogInfoRequestResponse(true));
    }

}
