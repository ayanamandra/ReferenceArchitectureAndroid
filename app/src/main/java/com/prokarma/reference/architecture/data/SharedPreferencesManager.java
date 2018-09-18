package com.prokarma.reference.architecture.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferencesManager {
    private static SharedPreferencesManager instance = null;
    private SharedPreferences sharedPreferences;

    public static SharedPreferencesManager getInstance() {
        if (instance == null) {
            instance = new SharedPreferencesManager();
        }

        return instance;
    }

    public void initializeSharedPreferences(final Context context){
        if (sharedPreferences == null){
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public SharedPreferences.Editor getEditor() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        return editor;
    }
}