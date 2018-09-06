package com.prokarma.reference.architecture.networking;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public abstract class NetworkManager {
    OkHttpClient initHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(20, TimeUnit.SECONDS);
        httpClient.connectTimeout(20, TimeUnit.SECONDS);

        return httpClient.build();
    }

    public abstract <T> T getRetroFitService();
}
