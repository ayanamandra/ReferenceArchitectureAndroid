package com.prokarma.reference.architecture.app;

import android.app.Application;

import com.prokarma.reference.architecture.networking.NetworkManager;

public class ReferenceApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //init retrofit service
        NetworkManager.getInstance().initService();
    }
}
