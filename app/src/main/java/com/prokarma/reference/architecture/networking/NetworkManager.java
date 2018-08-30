package com.prokarma.reference.architecture.networking;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.prokarma.reference.architecture.model.SearchEventsResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    private RESTService service = null;
    private static NetworkManager instance = null;
    private static OkHttpClient.Builder httpClient = null;
    public OkHttpClient client;

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }

        return instance;
    }

    public void initService() {
        if (client == null) {
            initHttpClient();
            client = httpClient.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(TicketMasterManager.TICKETMASTER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();

            service = retrofit.create(RESTService.class);
        }
    }

    private void initHttpClient() {
        httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(20, TimeUnit.SECONDS);
        httpClient.connectTimeout(20, TimeUnit.SECONDS);
    }

    public boolean canMakeNetworkCalls() {
        return service != null;
    }

    public Single<SearchEventsResponse> getEvents() {
        return TicketMasterManager.getEvents(service);
    }

    public Single<SearchEventsResponse> getEvents(String keyword) {
        return TicketMasterManager.getEvents(service, keyword);
    }

    public Call<SearchEventsResponse> getEventsNoRxJava(String keyword) {
        return TicketMasterManager.getEventsNoRxJava(service, keyword);
    }
}
