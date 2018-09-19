package com.prokarma.reference.architecture.di;

import com.prokarma.reference.architecture.feature.search.list.ListViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule extends AppModule {
    @Provides
    @Singleton
    ListViewModel provideListViewModel() {
        return new ListViewModel();
    }
}
