package com.prokarma.reference.architecture.core.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import timber.log.Timber;

/**
 * Custom wrapper class for logging purposes on debug builds.
 */
public class Logger {

    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    private final int mMaxLogLevel;

    public Logger(@NonNull Context context, int maxLogLevel) {
        mMaxLogLevel = maxLogLevel;
    }

    public void v(String tag, String message) {
        if (isLogLevelEnabled(VERBOSE)){
            Timber.v(tag, message);
        }
    }

    public void e(String tag, String message) {
        if (isLogLevelEnabled(ERROR)) {
            Timber.e(tag, message);
        }
    }

    public void d(String tag, String message) {
        if (isLogLevelEnabled(DEBUG)) {
            Timber.d(tag, message);
        }
    }

    private boolean isLogLevelEnabled(int logLevel) {
        return logLevel <= mMaxLogLevel;
    }
 }
