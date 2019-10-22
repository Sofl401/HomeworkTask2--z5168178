package com.example.homeworktask2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView totalSum;

    public OrderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_details, container, false);

        recyclerView = view.findViewById(R.id.orderRV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        OrderAdapter orderAdapter = new OrderAdapter();

        orderAdapter.setOrders(FoodDatabase.getAllOrders());
        recyclerView.setAdapter(orderAdapter);

        totalSum = view.findViewById(R.id.finalCost);
        String total = Double.toString(FoodDatabase.orderSum);
        totalSum.setText(total);
        return view;
    }
}
