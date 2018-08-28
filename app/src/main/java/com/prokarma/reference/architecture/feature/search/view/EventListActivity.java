package com.prokarma.reference.architecture.feature.search.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.databinding.ActivityEventListBinding;

/**
 * Activity representing a list of events. On big screen devices, this activity will additionally
 * display the event details on a secondary panel.
 */
public class EventListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityEventListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_event_list);
        setSupportActionBar(binding.toolbar);

    }

}
