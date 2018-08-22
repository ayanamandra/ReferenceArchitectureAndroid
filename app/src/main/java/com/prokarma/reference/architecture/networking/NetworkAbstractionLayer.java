package com.prokarma.reference.architecture.networking;

import android.support.annotation.Nullable;
import android.util.Log;

import com.prokarma.reference.architecture.SearchInterface;
import com.prokarma.reference.architecture.model.SearchEventsResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class NetworkAbstractionLayer {
    private static final String TAG = "NetworkAbstractionLayer";

    public static void getSearchEvents() {
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
    }

    public static void getSearchEvents(@Nullable final SearchInterface searchInterface, @Nullable String keyword) {
        NetworkManager.getInstance().getEvents(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<SearchEventsResponse>() {
                    @Override
                    public void onSuccess(SearchEventsResponse searchEventsResponse) {
                        Log.e(TAG, "Search Events found: " + searchEventsResponse.getPage().getTotalElements());
                        if (searchInterface != null){
                            searchInterface.updateValue(searchEventsResponse.getPage().getTotalElements().toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.getLocalizedMessage());
                    }
                });
    }

}
