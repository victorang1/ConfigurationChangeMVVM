package com.example.landscapeloader;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Bundle savedState;

    public ViewModelFactory(Bundle savedState) {
        this.savedState = savedState;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel();
    }
}
