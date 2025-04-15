package com.example.day2;


/*
     enum examples

     - HTTP Status codes
     - HTTP methods
     - Days of the week
     - Months of the year
     - Seasons
     - Error codes
     - Directions (NORTH, SOUTH, EAST, WEST)

 */

enum Gender{
    MALE,FEMALE,OTHER
}

class Employee{
    String name;
    Gender gender;
    Employee(String name,Gender gender){
        this.name=name;
        this.gender=gender;
    }
}

enum PaymentMode{
    CASH("Offline"),
    UPI("Online"),
    CARD("Online");
    String mode;
    PaymentMode(String mode){
        this.mode=mode;
    }
    public String getMode() {
        return mode;
    }
}


public class EnumDataType {

    public static void main(String[] args) {

        Employee e1=new Employee("A",Gender.MALE);
        Employee e2=new Employee("B",Gender.FEMALE);


        PaymentMode p1=PaymentMode.CASH;
        System.out.println(p1.getMode());


        switch (p1){
            case CASH:
                System.out.println("Cash");
                break;
            case UPI:
                System.out.println("UPI");
                break;
            case CARD:
                System.out.println("Card");
                break;
        }
        
    }
    
}
