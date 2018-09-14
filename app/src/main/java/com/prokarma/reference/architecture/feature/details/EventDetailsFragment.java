package com.prokarma.reference.architecture.feature.details;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.databinding.FragmentDetailsBinding;
import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.Location;
import com.prokarma.reference.architecture.model.WeatherReport;

public class EventDetailsFragment extends Fragment implements OnMapReadyCallback{
    private FragmentDetailsBinding mBinding;
    private DetailsViewModel mDetailsViewModel;
    private float DEFAULT_ZOOM = 10;
    private GoogleMap mMap = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
        mBinding.setLifecycleOwner(this);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDetailsViewModel = createViewModel();

        mDetailsViewModel.getEvent().observe(this, (Event event) -> {
            mBinding.setEvent(event);
            updateEventLocOnMap(event);
            updateWeatherInfo();
        });

        mDetailsViewModel.getWeatherReport().observe(this, (WeatherReport report) -> {
            //Shows the report by
            mBinding.setReport(report);
            mBinding.weatherReport.setVisibility(View.VISIBLE);
            mBinding.weatherReport.animate().alpha(100);
        });

        Event event = getArguments() != null ? (Event)getArguments().getSerializable("event") : null;
        mDetailsViewModel.setEventData(event);

    }

    //Fetch weather report at event venu on that particular day
    private void updateWeatherInfo() {
        mBinding.weatherReport.setVisibility(View.GONE);
        mDetailsViewModel.fetchWeatherReport();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void updateEventLocOnMap(Event event) {
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

    DetailsViewModel createViewModel() {
        return ViewModelProviders.of(this).get(DetailsViewModel.class);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        updateEventLocOnMap(mDetailsViewModel.getEvent().getValue());
    }
}
