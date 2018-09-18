package com.prokarma.reference.architecture.networking;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;

import com.prokarma.reference.architecture.data.SharedPreferencesConstants;
import com.prokarma.reference.architecture.data.SharedPreferencesManager;
import com.prokarma.reference.architecture.di.Injection;
import com.prokarma.reference.architecture.model.SearchEventsResponse;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationDataRepository {
    private static final String TAG = "AppDataRepository";

    @Inject
    TicketMasterManager ticketMasterManager;

    @Inject
    public ApplicationDataRepository() {
        Injection.create().getAppComponent().inject(this);
    }

    public void getSearchEvents(@Nullable final OnCallListener onCallListener, @Nullable String keyword) {
        ticketMasterManager.getEvents(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<SearchEventsResponse>() {
                    @Override
                    public void onSuccess(SearchEventsResponse searchEventsResponse) {
                        Log.e(TAG, "Search Events found: " + searchEventsResponse.getPage().getTotalElements());
                        if (onCallListener != null) {
                            onCallListener.onCallCompleted(searchEventsResponse);
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e(TAG, throwable.getLocalizedMessage());
                        if (onCallListener != null) {
                            onCallListener.onCallFailed(throwable);
                        }
                    }
                });
    }

    public void getSearchEventsNoRxJava(@Nullable final OnCallListener onCallListener, @Nullable String keyword) {
        ticketMasterManager.getEventsNoRxJava(keyword).enqueue(new Callback<SearchEventsResponse>() {
            @Override
            public void onResponse(Call<SearchEventsResponse> call, Response<SearchEventsResponse> response) {
                SearchEventsResponse searchEventsResponse = response.body();
                Log.e(TAG, "Search Events found: " + searchEventsResponse.getPage().getTotalElements());
                if (onCallListener != null) {
                    onCallListener.onCallCompleted(searchEventsResponse);
                }
            }

            @Override
            public void onFailure(Call<SearchEventsResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.getLocalizedMessage());
                if (onCallListener != null) {
                    onCallListener.onCallFailed(throwable);
                }
            }
        });
    }

    public static void updateUserSearchHistory(String searchHistory) {
        SharedPreferencesManager.getInstance().getEditor().putString(SharedPreferencesConstants.KEY_SEARCH_HISTORY, searchHistory).apply();
    }

    public static void getUserSearchHistory(@Nullable final OnCallListener onCallListener) {
        if (onCallListener != null) {
            onCallListener.onCallCompleted(SharedPreferencesManager.getInstance().getSharedPreferences().getString(SharedPreferencesConstants.KEY_SEARCH_HISTORY, ""));
        }
    }
}
