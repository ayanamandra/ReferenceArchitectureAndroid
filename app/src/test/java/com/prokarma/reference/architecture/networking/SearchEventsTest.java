package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.utils.TestUtil;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import retrofit2.Call;
import retrofit2.Response;

public class SearchEventsTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(20);

    @Test
    public void getEvents() {
        TestUtil.setupEnvironment();
        searchEvents();
        searchEvents("NHL");
    }

    private SearchEventsResponse searchEvents() {
        Single<SearchEventsResponse> call = NetworkManager.getInstance().getEvents();

        SearchEventsResponse response = call.blockingGet();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getPage());
        Assert.assertNotNull(response.getEmbedded());
        Assert.assertNotNull(response.getLinks());
        return response;
    }

    private SearchEventsResponse searchEvents(String keyword) {
        Single<SearchEventsResponse> call = NetworkManager.getInstance().getEvents(keyword);

        SearchEventsResponse response = call.blockingGet();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getPage());
        Assert.assertNotNull(response.getEmbedded());
        Assert.assertNotNull(response.getLinks());
        return response;
    }

}
