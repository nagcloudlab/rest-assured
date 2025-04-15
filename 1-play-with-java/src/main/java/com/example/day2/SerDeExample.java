package com.example.day2;

import com.example.model.Apple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDeExample {
    public static void main(String[] args) throws Exception{


        Apple apple = new Apple(100,"red");

        // Serialize
        FileOutputStream fos=new FileOutputStream("apple.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(apple);
        oos.close();
        fos.close();
        System.out.println("Serialized data is saved in apple.ser");

        // Deserialize
        FileInputStream fis = new FileInputStream("apple.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Apple apple1 = (Apple) ois.readObject();
        ois.close();
        fis.close();

        System.out.println("Deserialized Apple...");
        System.out.println("Weight: " + apple1.getWeight()+
                "\nColor: " + apple1.getColor());


    }
}
