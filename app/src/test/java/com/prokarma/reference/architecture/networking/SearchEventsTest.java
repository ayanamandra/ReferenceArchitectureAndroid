package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.utils.TestUtil;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class SearchEventsTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(20);

    @Test
    public void getEvents() {
        TestUtil.setupEnvironment();
        searchEvents();
    }

    private SearchEventsResponse searchEvents(){
        Call<SearchEventsResponse> call = NetworkManager.getInstance().getEvents();

        try {
            Response<SearchEventsResponse> response = call.execute();
            Assert.assertNotNull(response);
            Assert.assertTrue(response.isSuccessful());
            Assert.assertNotNull(response.body());
            Assert.assertNotNull(response.body().getPage());
            Assert.assertNotNull(response.body().getEmbedded());
            Assert.assertNotNull(response.body().getLinks());

            SearchEventsResponse updateResponse = response.body();
            Assert.assertNotNull(updateResponse);
            return updateResponse;
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
            return null;
        }
    }

}
