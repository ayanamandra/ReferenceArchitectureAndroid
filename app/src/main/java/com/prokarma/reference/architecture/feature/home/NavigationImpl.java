package com.prokarma.reference.architecture.feature.home;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class NavigationImpl implements NavigationInterface{
    @Override
    public NavController findNavigationController(ViewInterface viewInterface, int id, Bundle bundle) {
        return Navigation.findNavController(view).navigate(id, bundle);
    }
}
