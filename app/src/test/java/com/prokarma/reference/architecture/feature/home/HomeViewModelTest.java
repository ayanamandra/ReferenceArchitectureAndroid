package com.prokarma.reference.architecture.feature.home;

import android.content.Context;
import com.prokarma.reference.architecture.app.MainActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

public class HomeViewModelTest {

    private Context context;
    private MainActivity activity;
    HomeViewModel homeViewModel;

    @Before
    public void setUp() throws Exception {
        context = mock(Context.class);
        activity = mock(MainActivity.class);

//        homeViewModel = new HomeViewModel();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void search() {
        //TODO view required
        homeViewModel.search(view);
    }

    @Test
    public void getSearchQuery() {
    }

    @Test
    public void setSearchQuery() {
    }

    @Test
    public void getSearchKeyword() {
    }

    @Test
    public void setSearchKeyword() {
    }

    @Test
    public void onCleared() {
    }
}