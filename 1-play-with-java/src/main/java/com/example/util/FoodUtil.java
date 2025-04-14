package com.example.util;

import java.util.List;

class FoodUtil {
    private List<String> nonVegFoodList = List.of(
            "Chicken",
            "Fish",
            "Pork",
            "Beef",
            "Lamb",
            "Duck",
            "Turkey"
    );

    // method
    public static boolean isNonVeg(String food) {
        return food.equalsIgnoreCase("Chicken") ||
                food.equalsIgnoreCase("Fish") ||
                food.equalsIgnoreCase("Pork") ||
                food.equalsIgnoreCase("Beef") ||
                food.equalsIgnoreCase("Lamb") ||
                food.equalsIgnoreCase("Duck") ||
                food.equalsIgnoreCase("Turkey");
    }

}
