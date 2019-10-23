package com.example.homeworktask2;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
        totalSum.setText("$" + total);

        Button refresh = view.findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshFragment();
            }
        });

        return view;
    }
    private void refreshFragment(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        if (Build.VERSION.SDK_INT >= 26) {
            ft.setReorderingAllowed(false);
        }
        ft.detach(this).attach(this).commit();
    }
}
