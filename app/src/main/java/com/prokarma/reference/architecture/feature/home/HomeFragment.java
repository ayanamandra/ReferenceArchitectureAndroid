package com.prokarma.reference.architecture.feature.home;

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
import com.prokarma.reference.architecture.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {
    private HomeViewModel viewModel;
    private FragmentHomeBinding activityBinding;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        activityBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        activityBinding.setSearchViewModel(viewModel);
        activityBinding.setLifecycleOwner(this);
        return activityBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.getSearchHistory().observe(this, searchHistory -> {
            activityBinding.searchKeyword.setText(searchHistory);
        });

        viewModel.fetchUserSearchHistory();
    }
}
