package com.prokarma.reference.architecture.feature.search.event_list;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.prokarma.reference.architecture.databinding.FragmentEventListBinding;
import com.prokarma.reference.architecture.model.Event;

/**
 * Fragment responsible of displaying a list of {@link Event}
 */
public class EventListFragment extends Fragment {

    private EventRecyclerViewAdapter mAdapter;
    private FragmentEventListBinding mBinding;

    /**
     * Function to create a new instance of the fragment with the given bundle.
     * @return an {@link EventListFragment}
     */
    public EventListFragment newInstance(Bundle bundle) {
        EventListFragment newFragment = new EventListFragment();
        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentEventListBinding.inflate(inflater, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventViewModel eventViewModel = getViewModel();
        mAdapter = new EventRecyclerViewAdapter(eventViewModel, this);
        mBinding.recyclerview.setAdapter(mAdapter);
        eventViewModel.getEvents().observe(this, eventList -> {
            mAdapter.submitList(eventList);
        });
    }

    EventViewModel getViewModel() {
        return ViewModelProviders.of(this).get(EventViewModel.class);
    }
}
