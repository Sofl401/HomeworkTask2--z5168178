package com.example.homeworktask2;

public class Food {
    private int foodID;
    private String name;
    private String description;
    private double cost;
    private int calories;
    private int imageDrawableId;
    private int quantity;

    public Food(int foodID, String name, String description, double cost, int calories, int imageDrawableId) {
        this.foodID = foodID;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.calories = calories;
        this.imageDrawableId = imageDrawableId;
    }
    public Food(int foodID, String name, String description, double cost, int calories, int imageDrawableId, int quantity) {
        this.foodID = foodID;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.calories = calories;
        this.imageDrawableId = imageDrawableId;
        this.quantity=quantity;
    }


    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }
}
