package com.prokarma.reference.architecture.di;

import com.prokarma.reference.architecture.app.NavigationManager;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.networking.TicketMasterManager;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    // Exposing object to all accessible classes
    @Provides
    @Singleton
    NavigationManager provideNavigationManager(){
        return new NavigationManager();
    }

    @Provides
    @Singleton
    TicketMasterManager provideTicketManager(){
        return new TicketMasterManager();
    }

    @Provides
    @Singleton
    ApplicationDataRepository provideApplicationDataRepository(){
        return new ApplicationDataRepository();
    }
}
