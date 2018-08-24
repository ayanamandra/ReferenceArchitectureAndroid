package com.prokarma.reference.architecture.search;

import com.prokarma.reference.architecture.model.SearchEventsResponse;

public interface SearchInterface {

    void onSearchCompleted(SearchEventsResponse searchEventsResponse);

    void onSearchFailed(Throwable throwable);
}