package com.prokarma.reference.architecture.feature.home;

import android.os.Bundle;

import androidx.navigation.NavController;

public interface NavigationInterface {
    NavController findNavigationController(ViewInterface viewInterface, int id, Bundle bundle);
}
