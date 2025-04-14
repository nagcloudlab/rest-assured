package com.example.lambda;

/*
  Method Reference
 */

import java.util.List;
import java.util.function.Predicate;

class FoodUtil{
    private List<String> nonVegFoodList=List.of(
            "Chicken",
            "Fish",
            "Pork",
            "Beef",
            "Lamb",
            "Duck",
            "Turkey"
    );

    // method
    public static boolean isNonVeg(String food){
        return food.equalsIgnoreCase("Chicken") ||
                food.equalsIgnoreCase("Fish") ||
                food.equalsIgnoreCase("Pork") ||
                food.equalsIgnoreCase("Beef") ||
                food.equalsIgnoreCase("Lamb") ||
                food.equalsIgnoreCase("Duck") ||
                food.equalsIgnoreCase("Turkey");
    }

}

public class Ex3 {

    public static void main(String[] args) {

        String foodItem = "Chicken";
        boolean isNonVeg = FoodUtil.isNonVeg(foodItem);
        System.out.println("Is " + foodItem + " non-veg? " + isNonVeg);


        Predicate<String> isNonVegPredicate2 = (food) -> FoodUtil.isNonVeg(food);
        // or
        Predicate<String> isNonVegPredicate3 = FoodUtil::isNonVeg;
        // using existing method as a function using method reference
        isNonVeg= isNonVegPredicate2.test(foodItem);
        System.out.println("Is " + foodItem + " non-veg? " + isNonVeg);
    }

}
