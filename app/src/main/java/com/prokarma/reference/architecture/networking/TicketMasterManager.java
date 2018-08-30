package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.SearchEventsResponse;

import io.reactivex.Single;
import retrofit2.Call;

public class TicketMasterManager {
    private static final String API_KEY = "Ctl1pftvJYMyVJVycySAlLNDVhRMGBMb";
    private static final String TICKETMASTER_BASE_URL = "https://app.ticketmaster.com/";
    private static final String TICKETMASTER_URL = "https://app.ticketmaster.com/discovery/v2/events.json";

    public static String getTicketmasterBaseUrl() {
        return TICKETMASTER_BASE_URL;
    }

    public static Single<SearchEventsResponse> getEvents(RESTService service) {
        return service.getEvents(TICKETMASTER_URL, API_KEY);
    }

    public static Single<SearchEventsResponse> getEvents(RESTService service, String keyword) {
        return service.getEvents(TICKETMASTER_URL, API_KEY, keyword);
    }

    public static Call<SearchEventsResponse> getEventsNoRxJava(RESTService service, String keyword) {
        return service.getEventsNoRxJava(TICKETMASTER_URL, API_KEY, keyword);
    }
}
