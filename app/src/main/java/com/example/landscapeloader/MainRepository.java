package com.example.landscapeloader;

import java.util.ArrayList;

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
