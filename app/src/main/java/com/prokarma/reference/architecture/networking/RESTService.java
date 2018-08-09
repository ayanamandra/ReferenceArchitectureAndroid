package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.SearchEventsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface RESTService {
    String API_KEY = "apikey";

    @GET
    Call<SearchEventsResponse> getEvents(@Url String url, @Header(API_KEY) String bearer);
}
