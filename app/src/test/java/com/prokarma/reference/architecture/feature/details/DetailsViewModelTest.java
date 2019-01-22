package com.prokarma.reference.architecture.feature.details;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.prokarma.reference.architecture.app.MainActivity;
import com.prokarma.reference.architecture.di.AppComponent;
import com.prokarma.reference.architecture.di.AppModule;
import com.prokarma.reference.architecture.di.Injection;
import com.prokarma.reference.architecture.di.TestModule;
import com.prokarma.reference.architecture.feature.search.list.ListViewModel;
import com.prokarma.reference.architecture.model.Dates;
import com.prokarma.reference.architecture.model.Embedded;
import com.prokarma.reference.architecture.model.EmbeddedEvents;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.Location;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.model.StartDate;
import com.prokarma.reference.architecture.model.Venue;
import com.prokarma.reference.architecture.model.WeatherReport;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

public class DetailsViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Inject
    DetailsViewModel detailsViewModel;

    private Throwable throwable;

    @Before
    public void setUp() {
//        TestUtil.setupEnvironment();
        TestComponent testComponent = DaggerDetailsViewModelTest_TestComponent.builder().testModule(new TestModule())
                .build();

        Injection.create().setAppComponent(testComponent);
        testComponent.inject(this);
        MockitoAnnotations.initMocks(this);
        throwable = new Throwable();
    }

    @After
    public void tearDown() {
        throwable = null;
    }

    @Test
    public void getEvent() {
        Assert.assertNotNull(detailsViewModel.getEvent());
    }

    @Test
    public void setEventData() {
        Event actualEvent = new Event();
        actualEvent.id = "1kk8v4a_GA2UASi";
        actualEvent.name = "Paul McCartney - Freshen Up";
        actualEvent.url = "https://www.ticketmaster.com/paul-mccartney-freshen-up-phoenix-arizona-06-26-2019/event/190055259FD85CEC";
        actualEvent.embedded = new EmbeddedEvents();

        List<Venue> venues = new ArrayList<>();
        Venue venue1 = new Venue();
        Location location = new Location();
        location.longitude = "-112.071313";
        location.latitude = "33.445899";
        venue1.location = location;
        venues.add(venue1);
        actualEvent.embedded.venues = venues;

        actualEvent.dates = new Dates();
        actualEvent.dates.start = new StartDate();
        actualEvent.dates.start.localDate = "2018-12-29";
        actualEvent.dates.start.localTime = "19:30:00";
        actualEvent.dates.start.dateTime = "2018-12-30T00:30:00Z";

        detailsViewModel.setEventData(actualEvent);
        Assert.assertSame("event assigned correctly", actualEvent, detailsViewModel.getEvent().getValue());
    }

    @Test
    public void onCallCompletedWithNullWeatherResponse() {
        detailsViewModel.getWeatherReport().setValue(null);
        Object object = null;
        detailsViewModel.onCallCompleted(object);
        Assert.assertNull(detailsViewModel.getWeatherReport().getValue());
    }

    @Test
    public void onCallCompletedWithEmbeddedNullWeatherResponse() {
        List<WeatherReport> reports = new ArrayList<>();
        detailsViewModel.onCallCompleted(reports);
        Assert.assertNotNull(detailsViewModel.getWeatherReport());
    }

    @Test
    public void onCallCompletedWithNoWeatherResponse() {
        List<WeatherReport> reports = new ArrayList<>();
        detailsViewModel.onCallCompleted(reports);
        Assert.assertNotNull(detailsViewModel.getWeatherReport());
    }

    @Test
    public void onCallFailed() {
        detailsViewModel.onCallFailed(throwable);
        Assert.assertNotNull(detailsViewModel.getWeatherReport());
    }


    @Singleton
    @Component(modules = {TestModule.class})
    interface TestComponent extends AppComponent {
        void inject(DetailsViewModelTest test);
    }

}