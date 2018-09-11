package com.prokarma.reference.architecture.feature.search.list;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.feature.search.event_list.EventActions;
import com.prokarma.reference.architecture.model.Embedded;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.networking.OnCallListener;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.Navigation;


/**
 * View model in charge of {@link Event} handling.
 */
public class ListViewModel extends ViewModel implements EventListener, OnCallListener {
    private MutableLiveData<List<Event>> mEventsListLiveData;

    public ListViewModel() {

    }

    public void fetchEvents(String keyword) {
        ApplicationDataRepository.getSearchEventsNoRxJava(this, keyword);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        RequestOptions options = new RequestOptions()
                .fitCenter();

        Glide.with(view.getContext())
                .load(imageUrl)
                .apply(options)
                .into(view);
    }

    @Override
    public void openEventDetail(View view, String id) {
        Bundle bundle = new Bundle();
        bundle.putString("event_id", id);
        Navigation.findNavController(view).navigate(R.id.action_list_to_details, bundle);
    }

    @Override
    public void onCallCompleted(Object model) {

        //Validate input and handle alternative scenarios
        if (model != null) {
            Log.d("ListViewModel", "Call Completed " + model);
            Embedded embedded = ((SearchEventsResponse) model).getEmbedded();

            if (embedded != null) {
                List<Event> eventList = embedded.getEvents();
                getEvents().postValue(eventList);
            } else {
                //Handle none events found like a no results found view or displaying a message
                getEvents().postValue(new ArrayList<>());
            }
        } else {
            //Handle invalid arguments
            onCallFailed(new IllegalArgumentException("null argument"));
        }

    }

    @Override
    public void onCallFailed(Throwable throwable) {
        Log.e("ListViewModel", "Call Failed " + throwable);
        getEvents().postValue(new ArrayList<>());
    }

    public MutableLiveData<List<Event>> getEvents() {

        // Create a new Live data object if none exists.
        if (mEventsListLiveData == null) {
            mEventsListLiveData = new MutableLiveData<>();
        }
        return mEventsListLiveData;
    }
}

interface EventListener extends EventActions {
    /*
     * Extend with custom filters
     */
}
