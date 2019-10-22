package com.example.homeworktask2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderFragment extends Fragment {
    private RecyclerView recyclerView;

    public OrderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_details, container, false);

        recyclerView = view.findViewById(R.id.orderRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        OrderAdapter orderAdapter = new OrderAdapter();

        orderAdapter.setOrders(FoodDatabase.getAllOrders()); //TODO
        recyclerView.setAdapter(orderAdapter);

        //TODO create a separate adapter for the recyclerview for each orders and food
        return view;
    }
}
