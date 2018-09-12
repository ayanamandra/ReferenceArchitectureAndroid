package com.prokarma.reference.architecture.feature.search.list;

import android.arch.lifecycle.MutableLiveData;
import com.prokarma.reference.architecture.model.Embedded;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.utils.TestUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

public class ListViewModelTest {

    private ListViewModel listViewModel;
    private Throwable throwable;

    @Before
    public void setUp() throws Exception {
        TestUtil.setupEnvironment();
        listViewModel = new ListViewModel();
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
        SearchEventsResponse  searchEventsResponse = new SearchEventsResponse();
        listViewModel.onCallCompleted(searchEventsResponse);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());

    }

    @Test
    public void onCallCompletedwithNoEvents() {
        Assert.assertNull(listViewModel.getmEventsListLiveData());
        SearchEventsResponse  searchEventsResponse = new SearchEventsResponse();
        Embedded embedded = new Embedded();
        searchEventsResponse.embedded = embedded;
        listViewModel.onCallCompleted(searchEventsResponse);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());

    }

    @Test
    public void onCallCompleted() {
        Assert.assertNull(listViewModel.getmEventsListLiveData());
        SearchEventsResponse  searchEventsResponse = new SearchEventsResponse();

        Embedded embedded = new Embedded();

        Event event = new Event();
        List<Event> events= new ArrayList<>();

        events.add(event);

        embedded.events = events;

        searchEventsResponse.embedded = embedded;

        listViewModel.onCallCompleted(searchEventsResponse);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());
        //TODO please review this, posted events should handle here
//        Assert.assertEquals(searchEventsResponse.getEmbedded().getEvents(),listViewModel.getmEventsListLiveData().getValue().get(0));

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
        List<Event> events= new ArrayList<>();

        events.add(event);
        mEventsListLiveData.postValue(events);
        listViewModel.setmEventsListLiveData(mEventsListLiveData);
        Assert.assertNotNull(listViewModel.getmEventsListLiveData());
    }

    @Test
    public void getmEventsListLiveDataTest() {
        Event event = new Event();
        MutableLiveData<List<Event>> mEventsListLiveData = new MutableLiveData<>();
        List<Event> events= new ArrayList<>();

        events.add(event);
        mEventsListLiveData.postValue(events);
        listViewModel.setmEventsListLiveData(mEventsListLiveData);
        Assert.assertEquals(listViewModel.getmEventsListLiveData(), mEventsListLiveData);
    }

    @Test
    public void setmEventsListLiveDataTest() {
        Event event = new Event();
        MutableLiveData<List<Event>> mEventsListLiveData = new MutableLiveData<>();
        List<Event> events= new ArrayList<>();

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