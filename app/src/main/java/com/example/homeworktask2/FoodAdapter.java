package com.example.homeworktask2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private ArrayList<Food> foodList;

    public void setData(ArrayList<Food> foodList){
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);

        FoodViewHolder foodViewHolder = new FoodViewHolder(view);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        final Food foodPosition = foodList.get(position);

        holder.name.setText(foodPosition.getName());
        String sCost = Double.toString(foodPosition.getCost());
        holder.cost.setText(sCost);
        holder.itemImageView.setImageResource(foodPosition.getImageDrawableId());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Context context = view.getContext();

                Intent intent = new Intent(context, FoodDescription.class);
                intent.putExtra("FoodID", foodPosition.getFoodID());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView cost;
        public ImageView itemImageView;

        public FoodViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.name);
            cost = v.findViewById(R.id.cost);
            itemImageView = v.findViewById(R.id.image);
        }
    }
}
