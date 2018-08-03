package com.prokarma.reference.architecture;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

/**
 * A view model for search related support.
 */
public class SearchViewModel extends ViewModel {

    private final String TAG = "SearchViewModel";

    private String mSearchQuery;

    public SearchViewModel() {
        mSearchQuery = "";
    }

    /**
     * Search for related events to the given input.
     */
    public void search() {
        Log.d(TAG, "Search event triggered: " + mSearchQuery);
    }

    public String getSearchQuery() {
        return mSearchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        mSearchQuery = searchQuery;
    }
}
