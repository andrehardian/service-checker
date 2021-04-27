package com.ransom.servicechecker;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import connection.rxconnection.connection.ConnectionListener;
import connection.rxconnection.connection.HttpRequest;

public class MainActivity extends AppCompatActivity implements ConnectionListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        ((ServiceManager) new ServiceManager().setContext(this).setConnectionListener(this))
                .check();
    }

    @Override
    public void onSuccessWithData(Object o) {
        if (o instanceof ResponseAccess) {
            textView.setText(String.valueOf(((ResponseAccess) o).isAccess()));
        }
    }

    @Override
    public void onSuccessNull() {

    }

    @Override
    public void onMessageSuccess(String s) {

    }

    @Override
    public void onError(Object o, HttpRequest httpRequest) {
        textView.setText((String) o);
    }

    @Override
    public void unAuthorized(HttpRequest httpRequest, String messageError) {

    }
}