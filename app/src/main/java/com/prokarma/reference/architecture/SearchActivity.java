package com.prokarma.reference.architecture;

import com.prokarma.reference.architecture.databinding.ActivitySearchBinding;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivitySearchBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        final SearchViewModel viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        activityBinding.setSearchViewModel(viewModel);

        // Get the ViewModel.
        SearchViewModel mModel = ViewModelProviders.of(this).get(SearchViewModel.class);


        // Create the observer which updates the UI.
        final Observer<String> numberOfEventsObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newNumber) {
                // Update the UI, in this case, a TextView.
                activityBinding.searchNumberOfEvents.setText(newNumber);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getNumberOfEvents().observe(this, numberOfEventsObserver);
    }
}
