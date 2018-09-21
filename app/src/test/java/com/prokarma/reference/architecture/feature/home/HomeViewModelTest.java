package com.prokarma.reference.architecture.feature.home;

import android.content.Context;

import com.prokarma.reference.architecture.di.AppComponent;
import com.prokarma.reference.architecture.di.Injection;
import com.prokarma.reference.architecture.di.TestModule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

import static org.mockito.Mockito.mock;

public class HomeViewModelTest {

    @Inject
    HomeViewModel homeViewModel;

    Context context;

    @Before
    public void setUp() throws Exception {
        /*instrumentationCtx = InstrumentationRegistry.getContext();*/
        context = mock(Context.class);
        MockitoAnnotations.initMocks(this);
        TestComponent testComponent = DaggerHomeViewModelTest_TestComponent.builder()
                .testModule(new TestModule())
                .build();
        Injection.create().setAppComponent(testComponent);
        testComponent.inject(this);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSearchQuery() {
        String dummySearchQuery = "Dummy Search Query";
        homeViewModel.setSearchQuery(dummySearchQuery);
        Assert.assertEquals(dummySearchQuery, homeViewModel.getSearchQuery());
    }

    @Test
    public void setSearchQuery() {
        String dummySearchQuery = "Dummy Search Query";
        homeViewModel.setSearchQuery(dummySearchQuery);
        Assert.assertEquals(dummySearchQuery, homeViewModel.getSearchQuery());
    }

    @Test
    public void getSearchKeyword() {
        String dummySearchKeyword = "Dummy Search Keyword";
        homeViewModel.setSearchKeyword(dummySearchKeyword);
        Assert.assertEquals(dummySearchKeyword, homeViewModel.getSearchKeyword());
    }

    @Test
    public void setSearchKeyword() {
        String dummySearchKeyword = "Dummy Search Keyword";
        homeViewModel.setSearchKeyword(dummySearchKeyword);
        Assert.assertEquals(dummySearchKeyword, homeViewModel.getSearchKeyword());
    }

    @Test
    public void onCleared() {

    }

    @Singleton
    @Component(modules = { TestModule.class})
    interface TestComponent extends AppComponent {
        void inject(HomeViewModelTest test);
    }
}