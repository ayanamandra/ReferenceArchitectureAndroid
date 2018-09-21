package com.prokarma.reference.architecture.feature.search.event_list;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.Image;

import java.util.ArrayList;
import java.util.List;


/**
 * View model in charge of {@link Event} handling.
 */
public class EventViewModel extends ViewModel implements EventListener{

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

    @Override
    public void openEventDetail(View view, Event event) {

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
        mEventslLiveData.setValue(newEventsList);
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

/**
 * Interface used for extending the actions that can occur while handling events
 * such as applying filters, sorting given a specific criteria or more.
 */
interface EventListener extends EventActions {
    /*
     * Extend with custom filters
     */
}
