package com.prokarma.reference.architecture.feature.home;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.prokarma.reference.architecture.R;

import androidx.navigation.Navigation;

/**
 * A view model for search related support.
 */
public class HomeViewModel extends ViewModel {
    private final String TAG = "HomeViewModel";

    private String mSearchQuery;
    private String mSearchKeyword;

    public HomeViewModel() {
        mSearchQuery = "";
        mSearchKeyword = "";
    }

    /**
     * Search for related events to the given input.
     */
    public void search(View view) {
        Log.d(TAG, "Search event triggered: query = " + mSearchQuery + " keyword: " + mSearchKeyword);

        Bundle bundle = new Bundle();
        bundle.putString("keyword", mSearchKeyword);
        Navigation.findNavController(view).navigate(R.id.action_home_to_list, bundle);
    }

    public String getSearchQuery() {
        return mSearchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        mSearchQuery = searchQuery;
    }

    public String getSearchKeyword() {
        return mSearchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        mSearchKeyword = searchKeyword;
    }
}
