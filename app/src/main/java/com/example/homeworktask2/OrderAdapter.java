package com.example.homeworktask2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter {

    private ArrayList<Food> orderList;

    public void setOrders(ArrayList<Food> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);

        FoodAdapter.FoodViewHolder foodViewHolder = new FoodAdapter.FoodViewHolder(view);
        return foodViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //TODO
    }

    @Override
    public int getItemCount() {

        //TODO
        return 0;
    }
}
