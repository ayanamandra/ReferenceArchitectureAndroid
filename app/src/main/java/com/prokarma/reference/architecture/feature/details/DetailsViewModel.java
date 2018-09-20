package com.prokarma.reference.architecture.feature.details;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.prokarma.reference.architecture.feature.search.event_list.EventActions;
import com.prokarma.reference.architecture.model.Embedded;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.Location;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.networking.OnCallListener;

import java.util.ArrayList;
import java.util.List;


/**
 * View model in charge of {@link Event} handling.
 */
public class DetailsViewModel extends ViewModel implements OnMapReadyCallback {
    private MutableLiveData<Event> mEventLiveData;

    private GoogleMap mMap;
    private float DEFAULT_ZOOM = 10;

    public DetailsViewModel() {

    }

    public void setEventData(Event mEvent){
        // Create a new Live data object if none exists.
        if (mEventLiveData == null) {
            mEventLiveData = new MutableLiveData<>();
        }
        mEventLiveData.setValue(mEvent);
        updateEventLocOnMap();
    }

    public MutableLiveData<Event> getEvent() {

        // Create a new Live data object if none exists.
        if (mEventLiveData == null) {
            mEventLiveData = new MutableLiveData<>();
        }
        return mEventLiveData;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        updateEventLocOnMap();
    }

    public void updateEventLocOnMap() {
        Event event = getEvent().getValue();
        if(event.embedded.venues.size() > 0 && mMap != null){
            //Updates event location when map is ready.
            Location eventLocation = event.embedded.venues.get(0).location;
            LatLng eventLatLng = new LatLng(Double.valueOf(eventLocation.latitude),
                    Double.valueOf(eventLocation.longitude));
            CameraUpdate moveCamera = CameraUpdateFactory.newLatLngZoom(eventLatLng,
                    DEFAULT_ZOOM);
            mMap.moveCamera(moveCamera);

            mMap.addMarker(new MarkerOptions().position(eventLatLng));
        }
    }
}
