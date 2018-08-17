package com.prokarma.reference.architecture;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.prokarma.reference.architecture.core.util.Logger;

/**
 * Activity class to be extended by every activity on the application in order to have
 * access to common application resources.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private final String mTAG = getTAG();
    protected final Logger mLogger;
    protected final Context mApplicationContext;

    public BaseActivity(Context context) {
        this(context, new Logger(context.getApplicationContext(), Logger.DEBUG));
    }

    public BaseActivity(Context applicationContext, Logger logger) {
        mLogger = logger;
        mApplicationContext = applicationContext;
    }

    public abstract String getTAG();

}
