package com.prokarma.reference.architecture.utils;

import android.content.Context;
import android.content.SharedPreferences;
import org.mockito.Mockito;

import com.prokarma.reference.architecture.networking.NetworkManager;
import com.prokarma.reference.architecture.networking.TicketMasterManager;

public class TestUtil {

//    public static void setupEnvironment() {
//        TicketMasterManager.getInstance().getRetroFitService();
//        setSharedPreferences();
//    }

    //TODO: Remove hardcoded string when we make a preference helper class
    public static void setSharedPreferences() {
        final Context context = Mockito.mock(Context.class);
        final SharedPreferences sharedPrefs = Mockito.mock(SharedPreferences.class);
        Mockito.when(context.getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)).thenReturn(sharedPrefs);
    }
}
