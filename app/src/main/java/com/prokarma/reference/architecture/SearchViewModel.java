package com.prokarma.reference.architecture;

import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.widget.Toast;

import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.networking.NetworkManager;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        NetworkManager.getInstance().getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<SearchEventsResponse>() {
                    @Override
                    public void onSuccess(SearchEventsResponse searchEventsResponse) {
                        Log.e(TAG, "Search Events found: " + searchEventsResponse.getPage().getTotalElements());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getLocalizedMessage());
                    }
                });

//        NetworkManager.getInstance().getEvents().enqueue(new Callback<SearchEventsResponse>() {
//            @Override
//            public void onResponse(Call<SearchEventsResponse> call, Response<SearchEventsResponse> response) {
//                Log.e(TAG, "Search Events found: " + response.body().getPage().getTotalElements());
//            }
//
//            @Override
//            public void onFailure(Call<SearchEventsResponse> call, Throwable t) {
//                Log.e(TAG, t.getLocalizedMessage());
//            }
//        });
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
