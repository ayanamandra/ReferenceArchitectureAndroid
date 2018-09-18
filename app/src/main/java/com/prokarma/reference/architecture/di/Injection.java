package com.prokarma.reference.architecture.di;

public class Injection {

    private static Injection instance;
    private AppComponent appComponent;

    // creating dagger component
    private Injection(){
        appComponent = DaggerAppComponent.builder().build();
    }

    public static Injection create(){
        if(instance == null){
            instance = new Injection();
        }
        return instance;
    }
    public AppComponent getAppComponent(){
        return appComponent;
    }

}
