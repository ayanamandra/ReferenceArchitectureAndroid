package com.prokarma.reference.architecture.feature.search.list;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.prokarma.reference.architecture.feature.search.event_list.EventActions;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.Image;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.networking.NetworkAbstractionLayer;
import com.prokarma.reference.architecture.networking.NetworkInterface;

import java.util.ArrayList;
import java.util.List;


/**
 * View model in charge of event handling.
 */
public class ListViewModel extends ViewModel implements EventListener, NetworkInterface {

    //region Instance Variables
    private MutableLiveData<List<Event>> mEventslLiveData;
    //endregion

    //region Constructors
    public ListViewModel() {

    }
    //endregion

    //region Public methods
    public void fetchEvents(String keyword) {
        NetworkAbstractionLayer.getSearchEventsNoRxJava(this, keyword);
    }

    @Override
    public void openEventDetail(String id) {

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
        if (mEventslLiveData == null) {
            mEventslLiveData = new MutableLiveData<>();
        }
        return mEventslLiveData;
    }

    @Override
    public void onCallCompleted(Object model) {
        Log.d("ListViewModel", "Call Completed " + model);
        getEvents().postValue(((SearchEventsResponse) model).getEmbedded().getEvents());
    }

    @Override
    public void onCallFailed(Throwable throwable) {
        Log.e("ListViewModel", "Call Failed " + throwable);
        getEvents().postValue(new ArrayList<>());
    }
    //endregion
}

interface EventListener extends EventActions {
    /*
     * Extend with custom filters
     */
}
