package com.prokarma.reference.architecture.feature.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {
    private HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityHomeBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
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
    }

    @Override
    protected void onDestroy() {
        if (viewModel != null && viewModel.getNumberOfEvents().hasActiveObservers()) {
            viewModel.getNumberOfEvents().removeObservers(this);
        }

        super.onDestroy();
    }
}
