package com.prokarma.reference.architecture.app;

import android.app.Application;

public class ReferenceApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //init retrofit service
        //we no longer need to do this, as we always use the getter method of the class to get the service
        // and that method initializes the service if null (first call)
        //TicketMasterManager.getInstance().getRetroFitService();
    }
}
