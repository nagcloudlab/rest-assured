package com.example.lambda;

/*
  Method Reference
 */

import com.example.lambda.util.FoodUtil;

import java.util.function.Predicate;

public class Method_Reference {

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
