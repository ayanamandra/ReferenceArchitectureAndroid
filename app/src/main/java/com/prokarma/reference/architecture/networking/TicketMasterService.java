package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.SearchEventsResponse;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface TicketMasterService {
    String API_KEY = "apikey";
    String QUERY_KEYWORD = "keyword";

    @GET
    Single<SearchEventsResponse> getEvents(@Url String url, @Query(API_KEY) String apikey);

    @GET
    Single<SearchEventsResponse> getEvents(@Url String url, @Query(API_KEY) String apikey, @Query(QUERY_KEYWORD) String keyword);

    @GET
    Call<SearchEventsResponse> getEventsNoRxJava(@Url String url, @Query(API_KEY) String apikey, @Query(QUERY_KEYWORD) String keyword);
}
