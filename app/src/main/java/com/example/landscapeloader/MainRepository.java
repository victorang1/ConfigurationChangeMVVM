package com.example.landscapeloader;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainRepository {

    public static MainRepository instance;

    public static MainRepository getInstance() {
        if(instance == null) {
            instance = new MainRepository();
        }
        return instance;
    }

    public ArrayList<String> generateListData() {
        ArrayList<String> listName = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            listName.add("this is title " + i);
        }
        return listName;
    }
}
