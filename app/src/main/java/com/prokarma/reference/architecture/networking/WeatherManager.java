package com.prokarma.reference.architecture.networking;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.model.Weather.Location;
import com.prokarma.reference.architecture.model.Weather.Report;

import java.util.List;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.prokarma.reference.architecture.networking.WeatherService.PATH_DATE;
import static com.prokarma.reference.architecture.networking.WeatherService.PATH_WOEID;

public class WeatherManager extends NetworkManager {
    private static final String WEATHER_BASE_URL = "https://www.metaweather.com";
    private static final String LOCATION_SEARCH_URL = "/api/location/search/";
    private static final String LOCATION_DAY_URL = "/api/location/{"+PATH_WOEID+"}/{"+PATH_DATE+"}/";

    private static WeatherManager instance = null;
    private static TicketMasterService service = null;
    private OkHttpClient client;

    public static WeatherManager getInstance() {
        if (instance == null) {
            instance = new WeatherManager();
        }

        return instance;
    }

    @Override
    public <T> T getRetroFitService() {
        if (client == null) {
            client = initHttpClient();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(WEATHER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();

            service = retrofit.create(TicketMasterService.class);
        }

        return (T) service;
    }

    Single<List<Location>> getLocationsByArea(String query) {
        return ((WeatherService) getRetroFitService()).getLocationsByArea(WEATHER_BASE_URL + LOCATION_SEARCH_URL, query);
    }

    Single<List<Report>> getWeatherOnDay(String WOEID, String date) {
        return ((WeatherService) getRetroFitService()).getLocationDay(WEATHER_BASE_URL + LOCATION_DAY_URL, WOEID, date);
    }

}
