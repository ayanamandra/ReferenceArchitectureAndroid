package com.prokarma.reference.architecture.feature.search.list;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.prokarma.reference.architecture.feature.search.event_list.EventActions;
import com.prokarma.reference.architecture.model.Embedded;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.Image;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.networking.NetworkAbstractionLayer;
import com.prokarma.reference.architecture.networking.NetworkInterface;

import java.util.ArrayList;
import java.util.List;


/**
 * View model in charge of {@link Event} handling.
 */
public class ListViewModel extends ViewModel implements EventListener, NetworkInterface {

    //region Instance Variables
    private MutableLiveData<List<Event>> mEventsListLiveData;
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

    @Override
    public void onCallCompleted(Object model) {

        //TODO: Validate input and handle alternative scenarios
        if (model != null) {
            Log.d("ListViewModel", "Call Completed " + model);
            Embedded embedded = ((SearchEventsResponse) model).getEmbedded();

            if (embedded != null) {
                List<Event> eventList = embedded.getEvents();
                getEvents().postValue(eventList);
            } else {
                // TODO: Handle none events found like a no results found view or displaying a message
                getEvents().postValue(new ArrayList<>());
            }
        } else {
            // TODO: Handle invalid arguments
            onCallFailed(new IllegalArgumentException("null argument"));
        }

    }

    @Override
    public void onCallFailed(Throwable throwable) {
        Log.e("ListViewModel", "Call Failed " + throwable);
        getEvents().postValue(new ArrayList<>());
    }
    //endregion

    //region Private and protected methods

    //endregion

    //region Accessors and Mutators
    public MutableLiveData<List<Event>> getEvents() {

        // Create a new Live data object if none exists.
        if (mEventsListLiveData == null) {
            mEventsListLiveData = new MutableLiveData<>();
        }
        return mEventsListLiveData;
    }
    //endregion
}

interface EventListener extends EventActions {
    /*
     * Extend with custom filters
     */
}
