package com.prokarma.reference.architecture;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

/**
 * A view model for search related support.
 */
public class SearchViewModel extends ViewModel {

    private final String TAG = "SearchViewModel";

    //region Instance variables
    private String mSearchQuery;
    private String mSearchKeyword;
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
    //endregion
}
