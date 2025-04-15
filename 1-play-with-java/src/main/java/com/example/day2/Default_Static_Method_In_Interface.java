package com.example.day2;

// top-level : Interface  ( obj abstractions )

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

interface LivingThing{
    void eat();
    void sleep();
    default void work(){
        System.out.println("LivingThing works");
    }
}


// bottom-level : class ( obj implementations )

// Author : Animal-team
class Animal implements LivingThing{
    @Override
    public void eat() {
        System.out.println("Animal eats");
    }

    @Override
    public void sleep() {
        System.out.println("Animal sleeps");
    }
}

// Author : Human-team
class Human implements LivingThing{
    @Override
    public void eat() {
        System.out.println("Human eats");
    }

    @Override
    public void sleep() {
        System.out.println("Human sleeps");
    }

    @Override
    public void work() {
        System.out.println("Human works");
    }
}


class Worker{
    String name;
    double salary;
    Worker(String name,double salary){
        this.name=name;
        this.salary=salary;
    }
}

public class Default_Static_Method_In_Interface {
    public static void main(String[] args) {

        List<Integer> numbers=new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(4);

        Comparator<Integer> ascComparator=(n1,n2)->{
            return n1-n2;
        };
//        Comparator<Integer> descComparator=(n1,n2)->{
//            return n2-n1;
//        };
        Comparator<Integer> descComparator=ascComparator.reversed();
        numbers.sort(descComparator);

        System.out.println(numbers);


        List<Worker> workers=new ArrayList<>();
        workers.add(new Worker(null,1000));
        workers.add(new Worker("B",2000));
        workers.add(new Worker("C",1500));
        workers.add(new Worker("C",1200));

        Comparator<Worker> nameComparator=(w1,w2)->{
            return w1.name.compareTo(w2.name);
        };
        Comparator<Worker> nullFirstNameComparator=Comparator.nullsFirst(nameComparator);

        Comparator<Worker> salaryComparator=(w1,w2)->{
            return (int)(w1.salary-w2.salary);
        };

        Comparator<Worker> nameSalaryComparator=nameComparator.thenComparing(salaryComparator);
        workers.sort(nameSalaryComparator);



    }
}
