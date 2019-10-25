package com.example.landscapeloader;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.landscapeloader.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private MainViewModel mViewModel;
    private ArrayList<String> listName = new ArrayList<>();
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        observer();
        initAdapter();
        if(mViewModel._listPeople.getValue() == null)
            mViewModel.loadData();
    }

    private void observer(){
        mViewModel._listPeople.observe(this, listPeople-> {
                listName.clear();
                listName.addAll(listPeople);
                mAdapter.notifyDataSetChanged();
        });

        mViewModel.state.observe(this, state->{
            switch (state){
                case MainViewModel.SHOW_LOADING:
                    mBinding.rlContent.setVisibility(View.VISIBLE);
                    mBinding.recyclerView.setVisibility(View.GONE);
                    break;
                case MainViewModel.NO_LOADING:
                    mBinding.rlContent.setVisibility(View.GONE);
                    mBinding.recyclerView.setVisibility(View.VISIBLE);
                    break;
            }
        });
    }

    private void initAdapter() {
        mAdapter = new MainAdapter(listName);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setAdapter(mAdapter);
    }
}
