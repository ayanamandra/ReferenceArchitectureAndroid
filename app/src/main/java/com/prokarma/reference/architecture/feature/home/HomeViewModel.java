package com.prokarma.reference.architecture.feature.home;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.app.NavigationManager;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.networking.OnCallListener;

import androidx.navigation.Navigation;

/**
 * A view model for search related support.
 */
public class HomeViewModel extends ViewModel implements OnCallListener {
    private final String TAG = "HomeViewModel";

    private String mSearchQuery;
    private String mSearchKeyword;

    private MutableLiveData<String> mSearchHistory;

    public HomeViewModel() {
        mSearchQuery = "";
        mSearchKeyword = "";
    }

    /**
     * Search for related events to the given input.
     */
    public void search() {
        Log.d(TAG, "Search event triggered: query = " + mSearchQuery + " keyword: " + mSearchKeyword);

        Bundle bundle = new Bundle();
        bundle.putString("keyword", mSearchKeyword);
        updateUserSearchHistory(mSearchKeyword);
        NavigationManager.getInstance().getNavController().navigate(R.id.action_home_to_list, bundle);
    }

    public void fetchUserSearchHistory() {
        ApplicationDataRepository.getUserSearchHistory(this);
    }

    public void updateUserSearchHistory(final String searchHistory) {
        ApplicationDataRepository.updateUserSearchHistory(searchHistory);
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

    public MutableLiveData<String> getSearchHistory() {
        if (mSearchHistory == null) {
            mSearchHistory = new MutableLiveData<>();
        }

        return mSearchHistory;
    }

    public void setSearchHistory(MutableLiveData<String> mSearchHistory) {
        this.mSearchHistory = mSearchHistory;
    }

    @Override
    public void onCallCompleted(Object model) {
        getSearchHistory().postValue((String) model);
    }

    @Override
    public void onCallFailed(Throwable throwable) {
        Log.e(TAG, "Call Failed " + throwable);
        getSearchHistory().postValue(new String());
    }
}
