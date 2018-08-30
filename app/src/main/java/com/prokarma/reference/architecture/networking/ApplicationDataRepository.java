package com.prokarma.reference.architecture.networking;

import android.support.annotation.Nullable;
import android.util.Log;

import com.prokarma.reference.architecture.model.SearchEventsResponse;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationDataRepository {
    private static final String TAG = "AppDataRepository";

    public static void getSearchEvents(@Nullable final NetworkInterface networkInterface, @Nullable String keyword) {
        NetworkManager.getInstance().getEvents(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<SearchEventsResponse>() {
                    @Override
                    public void onSuccess(SearchEventsResponse searchEventsResponse) {
                        Log.e(TAG, "Search Events found: " + searchEventsResponse.getPage().getTotalElements());
                        if (networkInterface != null) {
                            networkInterface.onCallCompleted(searchEventsResponse);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e(TAG, throwable.getLocalizedMessage());
                        if (networkInterface != null) {
                            networkInterface.onCallFailed(throwable);
                        }
                    }
                });
    }

    public static void getSearchEventsNoRxJava(@Nullable final NetworkInterface networkInterface, @Nullable String keyword) {
        NetworkManager.getInstance().getEventsNoRxJava(keyword).enqueue(new Callback<SearchEventsResponse>() {
            @Override
            public void onResponse(Call<SearchEventsResponse> call, Response<SearchEventsResponse> response) {
                SearchEventsResponse searchEventsResponse = response.body();
                Log.e(TAG, "Search Events found: " + searchEventsResponse.getPage().getTotalElements());
                if (networkInterface != null) {
                    networkInterface.onCallCompleted(searchEventsResponse);
                }
            }

            @Override
            public void onFailure(Call<SearchEventsResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.getLocalizedMessage());
                if (networkInterface != null) {
                    networkInterface.onCallFailed(throwable);
                }
            }
        });
    }

}
