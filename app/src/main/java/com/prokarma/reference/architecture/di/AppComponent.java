package com.prokarma.reference.architecture.di;

import com.prokarma.reference.architecture.app.MainActivity;
import com.prokarma.reference.architecture.feature.home.HomeViewModel;
import com.prokarma.reference.architecture.feature.search.list.ListViewModel;
import com.prokarma.reference.architecture.networking.ApplicationDataRepository;
import com.prokarma.reference.architecture.networking.TicketMasterManager;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    // access dagger in this class
    void inject(HomeViewModel homeViewModel);

    void inject(MainActivity mainActivity);

    void inject(ListViewModel listViewModel);

    void inject(TicketMasterManager ticketMasterManager);

    void inject(ApplicationDataRepository applicationDataRepository);
}
