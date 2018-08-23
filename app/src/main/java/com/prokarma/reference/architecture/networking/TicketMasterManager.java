package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.SearchEventsResponse;

import io.reactivex.Single;

public class TicketMasterManager {
    private static final String API_KEY = "Ctl1pftvJYMyVJVycySAlLNDVhRMGBMb";
    protected static final String TICKETMASTER_BASE_URL = "https://app.ticketmaster.com/";
    private static final String TICKETMASTER_URL = "https://app.ticketmaster.com/discovery/v2/events.json";

    public static Single<SearchEventsResponse> getEvents(RESTService service) {
        return service.getEvents(TICKETMASTER_URL, API_KEY);
    }

    public static Single<SearchEventsResponse> getEvents(RESTService service, String keyword) {
        return service.getEvents(TICKETMASTER_URL, API_KEY, keyword);
    }
}
