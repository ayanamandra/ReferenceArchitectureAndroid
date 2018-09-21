package com.prokarma.reference.architecture.networking;

import com.prokarma.reference.architecture.di.AppComponent;
import com.prokarma.reference.architecture.di.TestModule;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.utils.TestUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.Single;

public class SearchEventsTest {

    @Inject
    ApplicationDataRepository applicationDataRepository;
    //@Rule
    //public Timeout globalTimeout = Timeout.seconds(20);

    @Before
    public void setUp() {
        SearchEventsTest.TestComponent testComponent = DaggerSearchEventsTest_TestComponent.builder().testModule(new TestModule())
                .build();
        testComponent.inject(this);
    }
    @Test
    public void getEvents() {
//        TestUtil.setupEnvironment();
        searchEvents();
        searchEvents("NHL");
    }

    private SearchEventsResponse searchEvents() {
        Single<SearchEventsResponse> call = applicationDataRepository.ticketMasterManager.getEvents();

        SearchEventsResponse response = call.blockingGet();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getPage());
        Assert.assertNotNull(response.getEmbedded());
        Assert.assertNotNull(response.getLinks());
        return response;
    }

    private SearchEventsResponse searchEvents(String keyword) {
        Single<SearchEventsResponse> call = applicationDataRepository.ticketMasterManager.getEvents(keyword);

        SearchEventsResponse response = call.blockingGet();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getPage());
        Assert.assertNotNull(response.getEmbedded());
        Assert.assertNotNull(response.getLinks());
        return response;
    }
    @Singleton
    @Component(modules = {TestModule.class})
    interface TestComponent extends AppComponent {
        void inject(SearchEventsTest test);
    }

}
