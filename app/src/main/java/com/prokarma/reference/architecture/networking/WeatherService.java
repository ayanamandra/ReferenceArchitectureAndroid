package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.model.Weather.Location;
import com.prokarma.reference.architecture.model.Weather.Report;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

import static com.prokarma.reference.architecture.networking.TicketMasterService.API_KEY;

public interface WeatherService {
    String QUERY_KEYWORD = "query";
    String QUERY_LATLNG= "lattlong"; //input: latitude,longitude
    String PATH_WOEID= "woeid";  //Where On Earth ID
    String PATH_DATE= "date"; // format yyyy/mm/dd

    @GET
    Single<List<Location>> getLocationsByArea(@Url String url, @Query(QUERY_KEYWORD) String query);
    @GET
    Single<List<Location>> getLocationsByLatLng(@Url String url, @Query(QUERY_LATLNG) String latlng);

    @GET
    Single<List<Report>> getLocationDay(@Url String url, @Path(PATH_WOEID) String woeid, @Path(PATH_DATE) String date);
}
