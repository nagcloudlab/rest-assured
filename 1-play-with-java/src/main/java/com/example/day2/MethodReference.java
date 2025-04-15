package com.example.day2;

import com.example.model.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

// to use existing java methods as functions , use method reference
public class MethodReference {
    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        // find low-calorie dish ( calories < 400) names, sort by calories

        menu
                .stream()
                .filter(d->d.getCalories()<400)
                .sorted((Comparator.comparing(Dish::getCalories)))
                .map(Dish::getName)
                .forEach(System.out::println);


        //----------------------------------

        // instance method reference
        Comparator<Integer> comparator1 = (i1, i2) -> i1.compareTo(i2);
        Comparator<Integer> comparator2 = Integer::compareTo;

        System.out.println(comparator1.compare(1, 2));
        System.out.println(comparator2.compare(1, 2));

        // static method reference
       Comparator<Integer> comparator3=(i1,i2)->Integer.compare(i1,i2);
       Comparator<Integer> comparator4=Integer::compare;

       // constructor reference
        Function<Integer,Product> function1=(id)->new Product(id);
        Function<Integer,Product> function2=Product::new;
        Product p1=function2.apply(123);

        BiFunction<Integer,String,Product> function3=(id,name)->new Product(id,name);
        BiFunction<Integer,String,Product> function4=Product::new;
        Product p2=function4.apply(123,"Product 1");

    }
}


class Product{
    int id;
    String name;
    Product(int id){
        this.id=id;
    }
    Product(int id, String name){
        this.id=id;
        this.name=name;
    }
}