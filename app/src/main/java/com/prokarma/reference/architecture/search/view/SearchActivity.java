package com.prokarma.reference.architecture.search.view;

import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.databinding.ActivitySearchBinding;
import com.prokarma.reference.architecture.search.viewmodel.SearchViewModel;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        final SearchViewModel viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        activityBinding.setSearchViewModel(viewModel);

    }
}
