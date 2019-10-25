package com.example.landscapeloader;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    public static final int SHOW_LOADING = 1;
    public static final int NO_LOADING = 2;

    private MainRepository mRepository;
    public MutableLiveData<Integer> state;
    public MutableLiveData<ArrayList<String>> _listPeople;

    public MainViewModel() {
        mRepository = MainRepository.getInstance();
        state = new MutableLiveData<>();
        _listPeople = new MutableLiveData<>();
    }

    public void loadData() {
        state.setValue(SHOW_LOADING);
        new Handler().postDelayed(() -> {
            _listPeople.setValue(mRepository.generateListData());
            state.setValue(NO_LOADING);
        }, 2000);
    }
}
