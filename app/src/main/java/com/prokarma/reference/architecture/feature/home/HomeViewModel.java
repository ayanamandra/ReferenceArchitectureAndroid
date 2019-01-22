package com.prokarma.reference.architecture.feature.home;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.util.Log;
import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.app.NavigationManager;
import com.prokarma.reference.architecture.di.Injection;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.networking.OnCallListener;
import javax.inject.Inject;

/**
 * A view model for search related support.
 */
public class HomeViewModel extends ViewModel implements OnCallListener {
    private final String TAG = "HomeViewModel";

    private String mSearchQuery;
    private String mSearchKeyword;

    @Inject
    NavigationManager navigationManager;

    @Inject
    ApplicationDataRepository applicationDataRepository;

    private MutableLiveData<String> mSearchHistory;

    public HomeViewModel() {
        Injection.create().getAppComponent().inject(this);
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
        navigationManager.getNavController().navigate(R.id.action_home_to_list, bundle);
    }

    public void fetchUserSearchHistory() {
        applicationDataRepository.getUserSearchHistory(this);
    }

    public void updateUserSearchHistory(final String searchHistory) {
        applicationDataRepository.updateUserSearchHistory(searchHistory);
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
