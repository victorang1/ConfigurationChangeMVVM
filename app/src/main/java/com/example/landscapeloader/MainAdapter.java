package com.example.landscapeloader;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.landscapeloader.databinding.ItemLayoutBinding;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private List<String> listName;

    public MainAdapter(List<String> listName) {
        this.listName = listName;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemLayoutBinding binding;

        public MyViewHolder(ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_layout, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MainAdapter.MyViewHolder myViewHolder, int i) {
        String data = listName.get(i);
        myViewHolder.binding.setViewModel(data);
    }

    @Override
    public int getItemCount() {
        return listName.size();
    }
}
