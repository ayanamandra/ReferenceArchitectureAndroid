package com.prokarma.reference.architecture.feature.details;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.prokarma.reference.architecture.feature.search.event_list.EventActions;
import com.prokarma.reference.architecture.model.Embedded;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.networking.OnCallListener;

import java.util.ArrayList;
import java.util.List;


/**
 * View model in charge of {@link Event} handling.
 */
public class DetailsViewModel extends ViewModel {
    private MutableLiveData<Event> mEventLiveData;

    public DetailsViewModel() {

    }

    public void setEventData(Event mEvent){
        mEventLiveData.setValue(mEvent);
    }

    public MutableLiveData<Event> getEvent() {

        // Create a new Live data object if none exists.
        if (mEventLiveData == null) {
            mEventLiveData = new MutableLiveData<>();
        }
        return mEventLiveData;
    }
}
