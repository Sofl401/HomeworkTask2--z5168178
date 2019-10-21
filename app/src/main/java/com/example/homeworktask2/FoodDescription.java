package com.example.homeworktask2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDescription extends AppCompatActivity {
    private TextView name;
    private TextView cost;
    private TextView calories;
    private TextView description;
    private ImageView image;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details);

        Intent intent = getIntent();
        int foodId = intent.getIntExtra("FoodID", 0);
        Food food = FoodDatabase.getFoodById(foodId);

        name = findViewById(R.id.detailName);
        cost = findViewById(R.id.detailCost);
        calories = findViewById(R.id.calories);
        description = findViewById(R.id.description);
        image = findViewById(R.id.detailImage);

        String sCost = Double.toString(food.getCost());
        String sCalories = Integer.toString(food.getCalories());

        name.setText(food.getName());
        description.setText(food.getDescription());
        cost.setText(sCost);
        calories.setText(sCalories);
        image.setImageResource(food.getImageDrawableId());


    }
}
