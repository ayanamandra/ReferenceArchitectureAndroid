package com.prokarma.reference.architecture;

import com.prokarma.reference.architecture.model.SearchEventsResponse;

public interface SearchInterface {

    void onSearchCompleted(SearchEventsResponse searchEventsResponse);
}
