package com.example;



/*

    style of programming
    1. imperative programming
    2. declarative programming

 */

import java.util.List;

class Apple{
    int weight;
    String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return  "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}


// User Defined types in java -> interface, class , enum , annotations , record

@FunctionalInterface
interface Predicate {
    boolean test(Apple apple);
}

// Named Classes
class GreenApplePredicate implements Predicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}

class RedApplePredicate implements Predicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("red");
    }
}

class WeightPredicate implements Predicate {
    private int weight;

    public WeightPredicate(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > weight;
    }
}

/*
 Why we need Lambda Expressions ( function ) in Java?
 */
public class Ex1 {
    public static void main(String[] args) {

        List<Apple> inventory = List.of(
                new Apple(100, "green"),
                new Apple(150, "red"),
                new Apple(50, "green"),
                new Apple(120, "red")
        );


        // client : farmer

        // Req-1: find all green apples
        System.out.println(
//                filterGreenApples(inventory)
//                filterApplesByColor(inventory, "green")
//                filterApples(inventory,new GreenApplePredicate())
                // Anonymous Classes
//                filterApples(inventory,new Predicate(){
//                    @Override
//                    public boolean test(Apple apple) {
//                        return apple.getColor().equals("green");
//                    }
//                })
                // From 1.8 onwards : Lambda Expression
                filterApples(inventory, (Apple apple) -> {
                    return apple.getColor().equals("green");
                })
        );

        // Req-2: find all red apples
        System.out.println(
//                filterRedApples(inventory)
//                filterApplesByColor(inventory, "red")
//                filterApples(inventory,new RedApplePredicate())
                // Anonymous Classes
//                filterApples(inventory,new Predicate(){
//                    @Override
//                    public boolean test(Apple apple) {
//                        return apple.getColor().equals("red");
//                    }
//                })
                // From 1.8 onwards : Lambda Expression ( concise way of writing anonymous classes)
                filterApples(inventory, (Apple apple) -> apple.getColor().equals("red"))
        );

        // Req-3: find all apples with weight > 100
        System.out.println(
//                filterApplesByWeight(inventory, 100)
//                filterApples(inventory, new WeightPredicate(100))
//                filterApples(inventory, new Predicate() {
//                    @Override
//                    public boolean test(Apple apple) {
//                        return apple.getWeight() > 100;
//                    }
//                })
                // Lambda Expression
                filterApples(inventory, (Apple apple) -> apple.getWeight() > 100)
        );

    }

    // declarative programming
    // - solving any problem by describing what to do
    // - intention + implementation decoupled
    // How ?
    // by passing primitive parameter
    // by passing object parameter
    // by passing function parameter ( function as parameter)

    // Why Function as parameter ?
    // --> to write concise code

    private static List<Apple> filterApples(List<Apple> inventory, Predicate predicate) {
        List<Apple> result = new java.util.ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

//    private static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
//        List<Apple> result = new java.util.ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getColor().equals(color)) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }
//
//    private static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
//        List<Apple> result = new java.util.ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getWeight() > weight) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }


    // imperative programming
    // - solving any problem step by step
    // - intention + implementation coupled together

//    public static List<Apple> filterGreenApples(List<Apple> inventory) {
//        List<Apple> result = new java.util.ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getColor().equals("green")) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }


//    public static List<Apple> filterRedApples(List<Apple> inventory) {
//        List<Apple> result = new java.util.ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getColor().equals("red")) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }

}
