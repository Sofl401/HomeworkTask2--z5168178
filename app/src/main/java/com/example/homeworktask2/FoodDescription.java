package com.example.homeworktask2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDescription extends AppCompatActivity {
    private TextView name;
    private TextView cost;
    private TextView calories;
    private TextView description;
    private ImageView image;
    private Spinner quanDrop;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details);
        Button addCart = findViewById(R.id.addOrder);

        addListenerOnSpinnerItemSelection();

        Intent intent = getIntent();
        final int foodId = intent.getIntExtra("FoodID", 0);
        Food food = FoodDatabase.getFoodById(foodId);

        name = findViewById(R.id.detailName);
        cost = findViewById(R.id.detailCost);
        calories = findViewById(R.id.calories);
        description = findViewById(R.id.description);
        image = findViewById(R.id.detailImage);

        String sCost = Double.toString(food.getCost());
        String sCalories = Integer.toString(food.getCalories());

        final String nameSlot = food.getName();
        name.setText(food.getName());
        description.setText(food.getDescription());
        cost.setText("$" + sCost);
        calories.setText(sCalories + " Calories");
        image.setImageResource(food.getImageDrawableId());

        final int orderId = food.getFoodID();
        final String orderName = food.getName();
        final String orderDesc = food.getDescription();
        final Double orderCost = food.getCost();
        final int orderCal = food.getCalories();
        final int orderPicture = food.getImageDrawableId();

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sQuantity = String.valueOf(quanDrop.getSelectedItem());
                int quantity = Integer.valueOf(sQuantity);


                Food item = new Food(orderId, orderName, orderDesc, orderCost, orderCal, orderPicture, quantity);
                FoodDatabase.addOrder(orderId, item, quantity);
                showOrderAdd(nameSlot);
            }
        });

}
    public void addListenerOnSpinnerItemSelection() {
        quanDrop = (Spinner) findViewById(R.id.spinner);
        quanDrop.setOnItemSelectedListener(new FoodOnItemSelectedListener());
    }
    public void showOrderAdd(String string) {
        Toast.makeText(this, "You've added " + string + " to your basket!", Toast.LENGTH_SHORT).show();
    }
}
