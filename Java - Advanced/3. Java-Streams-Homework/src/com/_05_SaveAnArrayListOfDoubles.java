package com;

import java.io.*;
import java.util.ArrayList;

public class _05_SaveAnArrayListOfDoubles {
    public static void main(String[] args) {
        try{
            ArrayList<Double> numbers = new ArrayList<>();
            numbers.add(5.5);
            numbers.add(3.2);
            numbers.add(4.75);

            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("doubles.list.txt")));
            oos.writeObject(numbers);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("doubles.list.txt")));
            System.out.println("Numbers: "  + ois.readObject());

        }catch (IOException ex){
            System.out.println("Problem with stream.");
        }catch (ClassNotFoundException ex){
            System.out.println("Problem with object input stream.");
        }
    }
}
