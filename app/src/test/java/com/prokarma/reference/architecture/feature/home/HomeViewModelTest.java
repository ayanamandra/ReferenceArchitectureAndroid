package com.prokarma.reference.architecture.feature.home;

import android.content.Context;
import android.widget.Button;

import com.prokarma.reference.architecture.app.MainActivity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class HomeViewModelTest {

    private Context context;
    private MainActivity activity;
    private NavigationInterface navigationInterface;
    private Button button;
    private HomeViewModel homeViewModel;

    @Before
    public void setUp() throws Exception {
        context = mock(Context.class);
        activity = mock(MainActivity.class);
        navigationInterface = mock(NavigationInterface.class);
        button = mock(Button.class);
        homeViewModel = new HomeViewModel(activity, navigationInterface);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void search() {
        homeViewModel.search();
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
}