package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.WeatherLocation;
import com.prokarma.reference.architecture.model.WeatherReport;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface WeatherService {
    String QUERY_KEYWORD = "query";
    String QUERY_LATLNG= "lattlong"; //input: latitude,longitude
    String PATH_WOEID= "woeid";  //Where On Earth ID
    String PATH_DATE= "date"; // format yyyy/mm/dd

    @GET
    Call<List<WeatherLocation>> getLocationsByArea(@Url String url, @Query(QUERY_KEYWORD) String query);
    @GET
    Call<List<WeatherLocation>> getLocationsByLatLng(@Url String url, @Query(QUERY_LATLNG) String latlng);

    @GET
    Call<List<WeatherReport>> getLocationDay(@Url String url, @Path(PATH_WOEID) int woeid, @Path(PATH_DATE) String date);
}
