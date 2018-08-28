package com.prokarma.reference.architecture.feature.search.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.networking.NetworkAbstractionLayer;
import com.prokarma.reference.architecture.networking.NetworkInterface;

/**
 * A view model for search related support.
 */
public class SearchViewModel extends ViewModel implements NetworkInterface {

    private final String TAG = "SearchViewModel";

    //region Instance variables
    private String mSearchQuery;
    private String mSearchKeyword;
    private MutableLiveData<String> mNumberOfEvents;
    //endregion

    //region Constructors
    public SearchViewModel() {
        mSearchQuery = "";
        mSearchKeyword = "";
    }
    //endregion

    //region Public methods

    /**
     * Search for related events to the given input.
     */
    public void search() {
        Log.d(TAG, "Search event triggered: query = " + mSearchQuery + " keyword: " + mSearchKeyword);
        NetworkAbstractionLayer.getSearchEventsNoRxJava(this, mSearchKeyword);
    }
    //endregion

    //region Accessors and Mutators
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

    // Create a LiveData with a String

    public MutableLiveData<String> getNumberOfEvents() {
        if (mNumberOfEvents == null) {
            mNumberOfEvents = new MutableLiveData<String>();
        }
        return mNumberOfEvents;
    }

    @Override
    public void onCallCompleted(Object model) {
        getNumberOfEvents().postValue(((SearchEventsResponse) model).getPage().getTotalElements().toString());
    }

    @Override
    public void onCallFailed(Throwable throwable) {
        getNumberOfEvents().postValue(throwable.getLocalizedMessage());
    }

    //endregion
}
