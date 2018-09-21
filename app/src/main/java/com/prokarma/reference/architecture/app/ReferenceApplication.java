package com.prokarma.reference.architecture.app;

import android.app.Application;

import com.prokarma.reference.architecture.data.SharedPreferencesManager;

import javax.inject.Inject;

public class ReferenceApplication extends Application {

    @Inject
    SharedPreferencesManager sharedPreferencesManager;

    @Override
    public void onCreate() {
        super.onCreate();

        //init retrofit service
        //we no longer need to do this, as we always use the getter method of the class to get the service
        // and that method initializes the service if null (first call)
        //TicketMasterManager.getInstance().getRetroFitService();

        sharedPreferencesManager.initializeSharedPreferences(this);
    }
}
