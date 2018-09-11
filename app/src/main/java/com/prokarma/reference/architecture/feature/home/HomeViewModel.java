package com.prokarma.reference.architecture.feature.home;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
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
    //TODO changes for unit testing
    private NavigationInterface navigationInterface;
    private Activity activity;

    public HomeViewModel(Activity activity ,NavigationInterface navigationInterface) {
        mSearchQuery = "";
        mSearchKeyword = "";
        //TODO changes for unit testing
        this.navigationInterface = navigationInterface;
        this.activity = activity;
    }

    /**
     * Search for related events to the given input.
     */
    public void search(View view) {
        Log.d(TAG, "Search event triggered: query = " + mSearchQuery + " keyword: " + mSearchKeyword);

        Bundle bundle = new Bundle();
        bundle.putString("keyword", mSearchKeyword);
        Navigation.findNavController(view).navigate(R.id.action_home_to_list, bundle);
        // TODO tried these things but stuck in the middle
//        Navigation.findNavController(activity,R.id.search_button).navigate(R.id.action_home_to_list, bundle);
//        navigationInterface.findNavigationController(viewInterface,R.id.action_home_to_list,bundle);
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
