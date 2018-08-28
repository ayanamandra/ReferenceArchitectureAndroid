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

/**
 * A placeholder fragment containing a simple view.
 */
public class EventListFragment extends Fragment {

    private EventRecyclerViewAdapter mAdapter;
    private FragmentEventListBinding mBinding;
    private EventViewModel mEventViewModel;

    public EventListFragment newInstance() {
        return new EventListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentEventListBinding.inflate(inflater, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEventViewModel = createViewModel();
        mAdapter = new EventRecyclerViewAdapter(mEventViewModel, this);
        mBinding.recyclerview.setAdapter(mAdapter);
        mEventViewModel.getEvents().observe(this, eventList -> {
            mAdapter.submitList(eventList);
        });
    }

    EventViewModel createViewModel() {
        return ViewModelProviders.of(this).get(EventViewModel.class);
    }
}
