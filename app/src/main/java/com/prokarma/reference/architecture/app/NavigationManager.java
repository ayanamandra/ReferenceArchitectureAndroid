package com.prokarma.reference.architecture.app;

import androidx.navigation.NavController;

public class NavigationManager {
    private NavController navController;

    public NavController getNavController() {
        return navController;
    }

    public void setNavController(NavController navController) {
        this.navController = navController;
    }
}
