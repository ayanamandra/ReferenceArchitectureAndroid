package com.prokarma.reference.architecture.networking;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;

import com.prokarma.reference.architecture.data.SharedPreferencesConstants;
import com.prokarma.reference.architecture.data.SharedPreferencesManager;
import com.prokarma.reference.architecture.model.SearchEventsResponse;
import com.prokarma.reference.architecture.model.WeatherLocation;
import com.prokarma.reference.architecture.model.WeatherReport;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationDataRepository {
    private static final String TAG = "AppDataRepository";

    public static void getSearchEvents(@Nullable final OnCallListener onCallListener, @Nullable String keyword) {
        TicketMasterManager.getInstance().getEvents(keyword)
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

    public static void getSearchEventsNoRxJava(@Nullable final OnCallListener onCallListener, @Nullable String keyword) {
        TicketMasterManager.getInstance().getEventsNoRxJava(keyword).enqueue(new Callback<SearchEventsResponse>() {
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

    public static String getWeatherIconUrl(String abbreviation){
        return WeatherManager.getWeatherIconUrl(abbreviation);
    }
    public static void getDayWeatherReport(@Nullable final OnCallListener onCallListener, @Nullable String latitude, @Nullable String longitude, @Nullable String day) {
        //Making locations call to identify the 'WOEID'(Where On Earth ID).
        WeatherManager.getInstance().getLocationsByLatLng(latitude, longitude).enqueue(new Callback<List<WeatherLocation>>() {
            @Override
            public void onResponse(Call<List<WeatherLocation>> call, Response<List<WeatherLocation>> response) {
                List<WeatherLocation> locations = response.body();
                Log.e(TAG, "Locations found: " + locations.size());
                if (locations.size() > 0) {
                    //Fetching weather report on that particular day for corresponding area (w.r.t WOEID)
                    WeatherManager.getInstance().getWeatherOnDay(locations.get(0).woeid, day).enqueue(new Callback<List<WeatherReport>>() {
                        @Override
                        public void onResponse(Call<List<WeatherReport>> call, Response<List<WeatherReport>> response) {
                            List<WeatherReport> reports = response.body();
                            if (onCallListener != null) {
                                onCallListener.onCallCompleted(reports);
                            }
                        }

                        @Override
                        public void onFailure(Call<List<WeatherReport>> call, Throwable throwable) {
                            if (onCallListener != null) {
                                onCallListener.onCallFailed(throwable);
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<WeatherLocation>> call, Throwable throwable) {
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
