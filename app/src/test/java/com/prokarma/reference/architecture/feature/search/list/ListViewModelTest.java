package com.prokarma.reference.architecture.feature.search.list;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.prokarma.reference.architecture.di.AppComponent;
import com.prokarma.reference.architecture.di.AppModule;
import com.prokarma.reference.architecture.di.Injection;
import com.prokarma.reference.architecture.feature.home.HomeViewModel;
import com.prokarma.reference.architecture.model.Embedded;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.utils.TestUtil;

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

public class ListViewModelTest {

    @Singleton
    @Component(modules = {AppModule.class})
    public interface TestComponent extends AppComponent {
        void inject(ListViewModelTest listViewModelTest);
    }


    private Throwable throwable;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Inject
    ListViewModel listViewModel;

    @Before
    public void setUp() throws Exception {
        TestUtil.setupEnvironment();
//        ListViewModelTest.TestComponent listViewModelTest = Dagger
//        Injection.create().getAppComponent().inject(this);
        MockitoAnnotations.initMocks(this);
        throwable = new Throwable();
    }

    @After
    public void tearDown() throws Exception {
        throwable = null;
        listViewModel = null;
    }

    @Test
    public void loadImage() {
        listViewModel.getEvents();
    }

    @Test
    public void openEventDetail() {
    }

    @Test
    public void onCallCompletedWithNullResponse() {
        Assert.assertNull(listViewModel.getmEventsListLiveData());
        Object object = null;
        listViewModel.onCallCompleted(object);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());
    }

    @Test
    public void onCallCompletedWithEmbeddedNull() {
        Assert.assertNull(listViewModel.getmEventsListLiveData());
        SearchEventsResponse searchEventsResponse = new SearchEventsResponse();
        listViewModel.onCallCompleted(searchEventsResponse);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());

    }

    @Test
    public void onCallCompletedwithNoEvents() {
        Assert.assertNull(listViewModel.getmEventsListLiveData());
        SearchEventsResponse searchEventsResponse = new SearchEventsResponse();
        Embedded embedded = new Embedded();
        searchEventsResponse.embedded = embedded;
        listViewModel.onCallCompleted(searchEventsResponse);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());

    }

    @Test
    public void onCallCompleted() {
        Assert.assertNull(listViewModel.getmEventsListLiveData());
        SearchEventsResponse searchEventsResponse = new SearchEventsResponse();
        Embedded embedded = new Embedded();

        Event event = new Event();
        event.id = "123";
        event.name = "fake event";

        List<Event> events = new ArrayList<>();

        events.add(event);
        embedded.events = events;
        searchEventsResponse.embedded = embedded;

        listViewModel.onCallCompleted(searchEventsResponse);

        Assert.assertNotNull(listViewModel.getmEventsListLiveData());

        Assert.assertEquals(searchEventsResponse.getEmbedded().getEvents(), listViewModel.getmEventsListLiveData().getValue());
    }


    @Test
    public void onCallFailed() {
        Assert.assertNull(listViewModel.getmEventsListLiveData());
        listViewModel.onCallFailed(throwable);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());
    }

    @Test
    public void getEventsWithNoEvents() {
        listViewModel.getEvents().postValue(null);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());
    }

    @Test
    public void getEventsWithValidEvents() {
        Event event = new Event();

        MutableLiveData<List<Event>> mEventsListLiveData = new MutableLiveData<>();
        List<Event> events = new ArrayList<>();

        events.add(event);
        mEventsListLiveData.postValue(events);
        listViewModel.setmEventsListLiveData(mEventsListLiveData);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());
    }

    @Test
    public void getmEventsListLiveDataTest() {
        Event event = new Event();
        MutableLiveData<List<Event>> mEventsListLiveData = new MutableLiveData<>();
        List<Event> events = new ArrayList<>();

        events.add(event);
        mEventsListLiveData.postValue(events);
        listViewModel.setmEventsListLiveData(mEventsListLiveData);
        Assert.assertEquals(listViewModel.getmEventsListLiveData(), mEventsListLiveData);
    }

    @Test
    public void setmEventsListLiveDataTest() {
        Event event = new Event();
        MutableLiveData<List<Event>> mEventsListLiveData = new MutableLiveData<>();
        List<Event> events = new ArrayList<>();

        events.add(event);
        mEventsListLiveData.postValue(events);
        listViewModel.setmEventsListLiveData(mEventsListLiveData);
        Assert.assertEquals(listViewModel.getmEventsListLiveData(), mEventsListLiveData);
    }


    @Test
    public void onCleared() {
        Assert.assertNotNull(throwable);
        Assert.assertNotNull(listViewModel);
    }
}