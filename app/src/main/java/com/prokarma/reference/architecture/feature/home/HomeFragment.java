package com.prokarma.reference.architecture.feature.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    private HomeViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final FragmentHomeBinding activityBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        activityBinding.setSearchViewModel(viewModel);

        // Create the observer which updates the UI.
        final Observer<String> numberOfEventsObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newNumber) {
                // Update the UI, in this case, a TextView.
                activityBinding.searchNumberOfEvents.setText(newNumber);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.getNumberOfEvents().observe(this, numberOfEventsObserver);
        activityBinding.setLifecycleOwner(this);
        return activityBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        if (viewModel != null && viewModel.getNumberOfEvents().hasActiveObservers()) {
            viewModel.getNumberOfEvents().removeObservers(this);
        }

        super.onDestroyView();
    }
}
