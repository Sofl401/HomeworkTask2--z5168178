package com.example.homeworktask2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FoodRecyclerFragment extends Fragment {
    private RecyclerView recyclerView;

    public FoodRecyclerFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_recycler, container, false);
        recyclerView = view.findViewById(R.id.foodRv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        FoodAdapter foodAdapter = new FoodAdapter();

        foodAdapter.setData(FoodDatabase.getAllFood());
        recyclerView.setAdapter(foodAdapter);

        return view;
    }
}
