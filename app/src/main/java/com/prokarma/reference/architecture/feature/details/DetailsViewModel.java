package com.prokarma.reference.architecture.feature.details;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.prokarma.reference.architecture.model.Event;
import com.prokarma.reference.architecture.model.Location;
import com.prokarma.reference.architecture.model.WeatherReport;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.networking.OnCallListener;

import java.util.List;


/**
 * View model in charge of {@link Event} handling.
 */
public class DetailsViewModel extends ViewModel implements OnCallListener {
    private MutableLiveData<Event> mEventLiveData;
    private MutableLiveData<WeatherReport> mWeatherReportLiveData;

    public DetailsViewModel() {

    }

    public void setEventData(Event mEvent){
        mEventLiveData.setValue(mEvent);
    }

    public MutableLiveData<Event> getEvent() {

        // Create a new Live data object if none exists.
        if (mEventLiveData == null) {
            mEventLiveData = new MutableLiveData<>();
        }
        return mEventLiveData;
    }

    public MutableLiveData<WeatherReport> getWeatherReport() {

        // Create a new Live data object if none exists.
        if (mWeatherReportLiveData == null) {
            mWeatherReportLiveData = new MutableLiveData<>();
        }
        return mWeatherReportLiveData;
    }

    public void fetchWeatherReport(){
        Location location = mEventLiveData.getValue().embedded.venues.get(0).location;
        String day = mEventLiveData.getValue().dates.start.localDate.replace('-','/');
        ApplicationDataRepository.getDayWeatherReport(this, location.latitude ,location.longitude,day);
    }

    @Override
    public void onCallCompleted(Object model) {
        if(model != null){
            List<WeatherReport> reports = (List<WeatherReport>) model;
            if(reports.size()>0){
                getWeatherReport().setValue(reports.get(0));
            }
        }

    }

    @Override
    public void onCallFailed(Throwable throwable) {

    }
}
