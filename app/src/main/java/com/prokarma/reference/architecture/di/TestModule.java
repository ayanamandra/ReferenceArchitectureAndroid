package com.prokarma.reference.architecture.di;

import com.prokarma.reference.architecture.feature.details.DetailsViewModel;
import com.prokarma.reference.architecture.feature.home.HomeViewModel;
import com.prokarma.reference.architecture.feature.search.list.ListViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule extends AppModule {
    @Provides
    @Singleton
    HomeViewModel provideHomeViewModel() {
        return new HomeViewModel();
    }

    @Provides
    @Singleton
    ListViewModel provideListViewModel() {
        return new ListViewModel();
    }

    @Provides
    @Singleton
    DetailsViewModel provideDetailsViewModel() {
        return new DetailsViewModel();
    }
}
