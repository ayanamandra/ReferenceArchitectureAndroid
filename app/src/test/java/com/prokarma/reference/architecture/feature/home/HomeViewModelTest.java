package com.prokarma.reference.architecture.feature.home;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HomeViewModelTest {

    private HomeViewModel homeViewModel;

    @Before
    public void setUp() throws Exception {
        homeViewModel = new HomeViewModel();
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