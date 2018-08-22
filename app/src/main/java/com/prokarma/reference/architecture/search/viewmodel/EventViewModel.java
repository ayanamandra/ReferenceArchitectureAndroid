package com.prokarma.reference.architecture.search.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.Image;

import java.util.ArrayList;
import java.util.List;


/**
 * View model in charge of event handling.
 */
public class EventViewModel {

    //region Instance Variables
    private MutableLiveData<List<Event>> mEventslLiveData;
    //endregion

    //region Constructors
    public EventViewModel() {

    }
    //endregion

    //region Public methods
    public void fetchEvents() {
        // Mock data repository access
        onEventsResult(new ArrayList<Event>());
    }
    //endregion

    //region Private and protected methods
    private void onEventsResult(List<Event> newEventsList) {

        // Create an Event
        Event eventAndroidIo = new Event();
        eventAndroidIo.name = "Android IO 2018";
        // Add Event image(s)
        Image eventImage = new Image();
        eventImage.url = " ";
        eventAndroidIo.images = new ArrayList<>();
        eventAndroidIo.images.add(eventImage);

        // Add Event(s) to event list
        newEventsList.add(eventAndroidIo);

        // Notify observers
        mEventslLiveData.postValue(newEventsList);
    }
    //endregion

    //region Accessors and Mutators
    public MutableLiveData<List<Event>> getEvents() {

        // Create a new Live data object if none exists.
        if(mEventslLiveData == null) {
            mEventslLiveData = new MutableLiveData<>();
            fetchEvents();
        }
        return mEventslLiveData;
    }
    //endregion
}
