package com.example.homeworktask2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FoodDatabase {
    private static final HashMap<Integer, Food> foods = new HashMap<>();

    public static Food getFoodById(int foodID)
    { return foods.get(foodID);}

    public static ArrayList<Food> getAllFood(){
        return new ArrayList<Food>((List) Arrays.asList(foods.values().toArray()));
    }
    static {
        foods.put(1, new Food(
                1,
                "Caesar Salad",
                "Fresh Iceberg Lettuce tossed with our homemade Caesar dressing, breadcrumbs and our shredded parmesian cheese.",
                9,
                94,
                R.drawable.caesar
        ));
        foods.put(2, new Food(
                2,
                "Spinach Salad",
                "Fresh spinach, mushrooms, and hard-boiled egg served with warm bacon vinaigrette.",
                6,
                107,
                R.drawable.spinach
        ));
        foods.put(3, new Food(
                3,
                "Lobster Bisque",
                "Fresh minced lobster in a thick, creamy broth with a touch of sherry. Prepared upon order fresh. Our Chef's Speciality",
                17,
                500,
                R.drawable.lobster
        ));
        foods.put(4, new Food(
                4,
                "Green Tea Ice-Cream",
                "This Japanese green tea Ice-cream is sweet also contains a hint of our specially imported matcha. Perfect for a hot summer day. ",
                8.95,
                500,
                R.drawable.matcha
        ));
        foods.put(5, new Food(
                5,
                "Roast Pork Loin",
                "Slow roasted pork loin finished with a wine sauce reduction. Served with oven-roasted vegetables and fresh chips. Marrow-scented couscous and wilted kale can be added",
                18,
                432,
                R.drawable.loin
        ));
        foods.put(6, new Food(
                6,
                "Wagyu Beef Burger",
                "Made from some of the most prized beef in the world, our beef burger is served with tomatoes, onions, lettuce and fresh chips.",
                22,
                823,
                R.drawable.wagyu
        ));
        foods.put(7, new Food(
                7,
                "Beer-Battered Seafood Platter",
                "Fresh haddock, gulf shrimp and sea scallops dipped in beer batter and fried to a beautiful golden grown. Served over fries or salad.",
                18,
                921,
                R.drawable.beerfish
        ));
        foods.put(8, new Food(
                8,
                "Traditional Shrimp Scampi",
                "Gulf shrimp sauteed with mushrooms and fresh garlic. Finished with sweet cream butter, scallions and reduced in a white wine.",
                18,
                654,
                R.drawable.shrimp
        ));
        foods.put(9, new Food(
                9,
                "Chicken Picatta",
                "Lightly breaded boneless chicken sauteed in butter and white wine sauce, finished with capers and freshly squeezed lemon",
                16,
                781,
                R.drawable.piccata
        ));
        foods.put(10, new Food(
                10,
                "Bacon Bourbun Rib Eye",
                "Thick, hand-cut Rib-Eye grilled to order, served with baked potatoes, chips and our homemade bourbon BBQ Sauce",
                26,
                1342,
                R.drawable.ribeye
        ));
        foods.put(11, new Food(
                11,
                "Southwest Turkey Club",
                "Sliced turkey on a toasted roll with bacon, lettuce and tomatoes and avacado-ranch dressing. Served with chips or a salad of your choice.",
                23,
                619,
                R.drawable.turkey
        ));
        foods.put(12, new Food(
                12,
                "Pulled Pork",
                "Slow roasted pork simmered in tangy BBQ Sauce and served on a toasted roll with cheddar cheese.",
                18,
                1032,
                R.drawable.pulledpork
        ));
        foods.put(13, new Food(
                13,
                "Carribean Jerk Wings",
                "Jerk spiced-rubbed chicken wings topped with swiss cheese and grilled pineapple.",
                17,
                721,
                R.drawable.jerk
        ));
        foods.put(14, new Food(
                14,
                "Oreo Parfait",
                "A sweet creamy blend of ice-cream topped with crushed Oreo's. A perfect dessert to end a meal.",
                9,
                397,
                R.drawable.oreo
        ));
        foods.put(15, new Food(
                15,
                "Black And Blue Burger",
                "Angus patty rubbed with freshly ground black bepper and topped with melted creamy blue cheese.",
                26,
                1462,
                R.drawable.angus
        ));

    }
}
