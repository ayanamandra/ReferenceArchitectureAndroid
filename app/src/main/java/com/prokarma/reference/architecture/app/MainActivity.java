package com.prokarma.reference.architecture.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.prokarma.reference.architecture.R;

import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationManager.getInstance().setNavController(Navigation.findNavController(this, R.id.my_nav_host_fragment));
    }
}
