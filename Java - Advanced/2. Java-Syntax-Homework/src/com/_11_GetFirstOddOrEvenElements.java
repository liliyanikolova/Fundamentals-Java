package com;

import java.util.ArrayList;
import java.util.Scanner;

public class _11_GetFirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");
        String[] inputCommand = scanner.nextLine().split(" ");
        String type = inputCommand[2];
        Integer count = Integer.parseInt(inputCommand[1]);
        ArrayList<String> resultList = getOddOrEven(inputArray, type, count);
        System.out.println(String.join(" ", resultList));
    }

    public static ArrayList<String> getOddOrEven(String[] collection, String type, int count){
        ArrayList<String> resultNumbers = new ArrayList<>();
        for (String element : collection) {
            try {
                Long num =Long.parseLong(element);
                if (type.equals("odd")){
                    if (num % 2 == 1) {
                        resultNumbers.add(element.toString());
                    }
                } else {
                    if (num % 2 == 0) {
                        resultNumbers.add(element.toString());
                    }
                }
            }
            catch (NumberFormatException ex){
                continue;
            }
        }

        return resultNumbers;
    }
}
