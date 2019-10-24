package com.example.homeworktask2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import static android.view.View.VISIBLE;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private ArrayList<Food> orderList;

    public void setOrders(ArrayList<Food> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);

        OrderViewHolder orderViewHolder = new OrderViewHolder(view);
        return orderViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, int position) {
        final Food foodPosition = orderList.get(position);
        final int id = foodPosition.getFoodID();
        final String nameHolder = foodPosition.getName();
        final int current = foodPosition.getQuantity();

        holder.delete.setVisibility(VISIBLE);
        holder.name.setText(foodPosition.getName());
        String sCost = Double.toString(foodPosition.getCost());
        holder.cost.setText("Total: $" +sCost);
        holder.itemImageView.setImageResource(foodPosition.getImageDrawableId());
        holder.quantity.setText("Quantity Ordered: " + String.valueOf(current));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Context context = view.getContext();

                Intent intent = new Intent(context, FoodDescription.class);
                intent.putExtra("FoodID", foodPosition.getFoodID());
                context.startActivity(intent);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "You've removed (1) "+ nameHolder + " from your basket! Refresh to see your updated Basket" , Toast.LENGTH_SHORT).show();

                if (current > 1) {
                    foodPosition.setQuantity(foodPosition.getQuantity() - 1);
                }
                else {
                    FoodDatabase.removeItem(id);
                }
                if (FoodDatabase.orderSum > 0) {
                    FoodDatabase.orderSum -= foodPosition.getCost();
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView cost;
        public ImageView itemImageView;
        public TextView quantity;
        public Button delete;

        public OrderViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.name);
            cost = v.findViewById(R.id.cost);
            itemImageView = v.findViewById(R.id.image);
            quantity = v.findViewById(R.id.quantity);
            delete = v.findViewById(R.id.delete);
        }
    }
}
