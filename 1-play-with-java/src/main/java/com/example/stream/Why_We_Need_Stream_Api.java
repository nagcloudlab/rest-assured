package com.example.stream;


import com.example.model.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// to write data processing pipelines in declarative way
/*

data processing
e.g

    -> filtering
    -> soring
    -> transformation
    -> sum/avg/min/max
    -> exist
    -> grouping
    -> joining
    ....

 */


public class Why_We_Need_Stream_Api {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        // get low calorie dish ( calories < 400) names in ascending order (calories)
        System.out.println(
                getLowCalorieDishNamesV1(menu, 400)
        );

        System.out.println(
                getLowCalorieDishNamesV2(menu, 400)
        );

    }


    // declarative approach
    // -> easy to read and maintain
    // -> easy to parallelize ( time saving)
    // -> easy to test
    // -> easy to reuse
    public static List<String> getLowCalorieDishNamesV2(List<Dish> menu, int calorie) {
        return menu
                .stream()
                .filter(dish -> dish.getCalories() < calorie)
                .sorted((d1, d2) -> Double.compare(d1.getCalories(), d2.getCalories()))
                .map(d -> d.getName())
                .collect(Collectors.toList());
    }

    // imperative approach
    // -> hard to read and maintain
    // -> hard to parallelize ( time consuming)
    // -> hard to test
    // -> hard to reuse
    // -> hard to understand
    public static List<String> getLowCalorieDishNamesV1(List<Dish> menu, int calorie) {
        // step-1 : filter the dishes
        List<Dish> lowCalorieDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < calorie) {
                lowCalorieDishes.add(dish);
            }
        }
        // step-2 : sort the dishes
        lowCalorieDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Double.compare(d1.getCalories(), d2.getCalories());
            }
        });
        // step-3 : get the names of the dishes
        List<String> lowCalorieDishNames = new ArrayList<>();
        for (Dish dish : lowCalorieDishes) {
            lowCalorieDishNames.add(dish.getName());
        }
        return lowCalorieDishNames;
    }

}
