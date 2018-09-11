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

import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.databinding.FragmentDetailsBinding;
import com.prokarma.reference.architecture.databinding.FragmentListBinding;
import com.prokarma.reference.architecture.feature.search.list.ListViewModel;

public class EventDetailsFragment extends Fragment {
    private FragmentDetailsBinding mBinding;
    private DetailsViewModel mDetailsViewModel;

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

        mDetailsViewModel.getEvent().observe(this, event -> {
            mBinding.setEvent(event);
        });

        String keyword = getArguments() != null ? getArguments().getString("keyword") : "";

    }

    DetailsViewModel createViewModel() {
        return ViewModelProviders.of(this).get(DetailsViewModel.class);
    }
}
