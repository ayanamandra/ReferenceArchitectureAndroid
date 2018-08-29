package com.prokarma.reference.architecture.feature.search.list;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.databinding.FragmentListBinding;

public class ListFragment extends Fragment {
    private ListRecyclerViewAdapter mAdapter;
    private FragmentListBinding mBinding;
    private ListViewModel mListViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
        mBinding.setLifecycleOwner(this);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListViewModel = createViewModel();
        mAdapter = new ListRecyclerViewAdapter(mListViewModel, this);
        mBinding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mBinding.recyclerview.setAdapter(mAdapter);
        mListViewModel.getEvents().observe(this, eventList -> {
            mAdapter.submitList(eventList);
        });

        String keyword = getArguments() != null ? getArguments().getString("keyword") : "";
        mListViewModel.fetchEvents(keyword);
    }

    ListViewModel createViewModel() {
        return ViewModelProviders.of(this).get(ListViewModel.class);
    }
}
