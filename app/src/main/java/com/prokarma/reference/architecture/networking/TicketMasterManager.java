package com.prokarma.reference.architecture.networking;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.prokarma.reference.architecture.model.SearchEventsResponse;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TicketMasterManager extends NetworkManager {
    private static final String API_KEY = "Ctl1pftvJYMyVJVycySAlLNDVhRMGBMb";
    private static final String TICKETMASTER_BASE_URL = "https://app.ticketmaster.com/";
    private static final String TICKETMASTER_URL = "https://app.ticketmaster.com/discovery/v2/events.json";

    private static TicketMasterManager instance = null;
    private static TicketMasterService service = null;
    private OkHttpClient client;

    public static TicketMasterManager getInstance() {
        if (instance == null) {
            instance = new TicketMasterManager();
        }

        return instance;
    }

    @Override
    public <T> T getRetroFitService() {
        if (client == null) {
            client = initHttpClient();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(TICKETMASTER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();

            service = retrofit.create(TicketMasterService.class);
        }

        return (T) service;
    }

    Single<SearchEventsResponse> getEvents() {
        return ((TicketMasterService) getRetroFitService()).getEvents(TICKETMASTER_URL, API_KEY);
    }

    Single<SearchEventsResponse> getEvents(String keyword) {
        return ((TicketMasterService) getRetroFitService()).getEvents(TICKETMASTER_URL, API_KEY, keyword);
    }

    Call<SearchEventsResponse> getEventsNoRxJava(String keyword) {
        return ((TicketMasterService) getRetroFitService()).getEventsNoRxJava(TICKETMASTER_URL, API_KEY, keyword);
    }
}
