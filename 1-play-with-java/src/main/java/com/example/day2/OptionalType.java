package com.example.day2;

/*
    Person -> Car ( optional )  -> Insurance( optional )
 */

import java.util.List;
import java.util.Optional; // ( from java 1.8)

class Insurance{
    String name;
    Insurance(String name){
        this.name=name;
    }
}

class Car{
    String name;
    //Insurance insurance=null;
    Optional<Insurance> insurance=Optional.empty();
    Car(String name,Insurance insurance){
        this.name=name;
        this.insurance=Optional.ofNullable(insurance);
    }
}

class Person{
    String name;
    //Car car=null;
    Optional<Car> car=Optional.empty();
    Person(String name,Car car){
        this.name=name;
        this.car=Optional.ofNullable(car);
    }
}


public class OptionalType {
    public static void main(String[] args) {


        // scenario 1 : Person has a car and car has insurance
        Insurance i1=new Insurance("Insurance1");
        Car c1=new Car("Car1",null);
        Person p1=new Person("Person1",c1);

        String insuranceName=p1.car
                .flatMap(car -> car.insurance)
                .map(insurance -> insurance.name)
                .orElse("No Insurance");
        System.out.println(insuranceName); // Insurance1


        Optional<Car> carOptional = p1.car;
        if(carOptional.isPresent()) {
            Car car = carOptional.get();
            Optional<Insurance> insuranceOptional = car.insurance;
            if (insuranceOptional.isPresent()) {
                Insurance insurance = insuranceOptional.get();
                System.out.println(insurance.name);
            } else {
                System.out.println("No Insurance");
            }
        }

        carOptional.orElseThrow(()->new IllegalStateException("Car not present"));


        List<Integer> numbers=List.of(1,2,3,4,5);

       Optional<Integer> optionalI= numbers
                .stream()
                .filter(n->n%2==0)
                .filter(n->n>4)
                .findFirst();

        if(optionalI.isPresent()){
            System.out.println(optionalI.get());
        }else{
            System.out.println("No value present");
        }



    }
}
