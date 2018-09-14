package com.prokarma.reference.architecture.app;

import androidx.navigation.NavController;

public class NavigationManager {
    private static NavigationManager instance;
    private NavController navController;

    public static NavigationManager getInstance() {
        if (instance == null) {
            instance = new NavigationManager();
        }

        return instance;
    }

    public NavController getNavController() {
        return navController;
    }

    public void setNavController(NavController navController) {
        this.navController = navController;
    }
}
