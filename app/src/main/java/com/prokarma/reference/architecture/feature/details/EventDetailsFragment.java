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

public class EventDetailsFragment extends Fragment {
    private FragmentDetailsBinding mBinding;
    private DetailsViewModel mDetailsViewModel;
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
        });

        mDetailsViewModel.getWeatherReport().observe(this, (WeatherReport report) -> {
            //Shows weather report
            mBinding.setReport(report);
        });

        Event event = getArguments() != null ? (Event)getArguments().getSerializable("event") : null;
        mDetailsViewModel.setEventData(event);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(mDetailsViewModel);
    }

    DetailsViewModel createViewModel() {
        return ViewModelProviders.of(this).get(DetailsViewModel.class);
    }
}
