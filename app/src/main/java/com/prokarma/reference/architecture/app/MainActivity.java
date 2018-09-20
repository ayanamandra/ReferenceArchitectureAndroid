package com.prokarma.reference.architecture.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.prokarma.reference.architecture.R;
import com.prokarma.reference.architecture.di.Injection;

import javax.inject.Inject;

import androidx.navigation.Navigation;


public class MainActivity extends AppCompatActivity {

    // creating reference to access the object
    @Inject
    NavigationManager navigationManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // accessing all dagger objects
        Injection.create().getAppComponent().inject(MainActivity.this);

        navigationManager.setNavController(Navigation.findNavController(this, R.id.my_nav_host_fragment));
    }
}
