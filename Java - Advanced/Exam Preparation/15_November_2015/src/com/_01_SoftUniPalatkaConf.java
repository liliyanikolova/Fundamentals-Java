package com;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class _01_SoftUniPalatkaConf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer peopleNumber = scanner.nextInt();
        scanner.nextLine();
        int rows = scanner.nextInt();
        scanner.nextLine();

        LinkedHashMap<String, Integer> databaseBeds = new LinkedHashMap<>();
        databaseBeds.put("normal", 2);
        databaseBeds.put("firstClass", 3);
        databaseBeds.put("single", 1);
        databaseBeds.put("double", 2);
        databaseBeds.put("triple", 3);

        LinkedHashMap<String, Integer> databaseFood = new LinkedHashMap<>();
        databaseFood.put("musaka", 2);
        databaseFood.put("zakuska", 0);

        int totalFed = 0;
        int totalBeds = 0;
        for (int j = 0; j < rows; j++) {
            String[] input = scanner.nextLine().split("\\s+");
            String provission = input[0];
            int quantity = Integer.parseInt(input[1]);
            String type = input[2];

            if (databaseBeds.containsKey(type)){
                totalBeds += quantity * databaseBeds.get(type);
            }

            if (databaseFood.containsKey(type)){
                totalFed += quantity * databaseFood.get(type);
            }
        }

        if (totalBeds >= peopleNumber){
            System.out.printf("Everyone is happy and sleeping well. Beds left: %d\n",totalBeds - peopleNumber);
        }else {
            System.out.printf("Some people are freezing cold. Beds needed: %d\n", peopleNumber - totalBeds);
        }

        if (totalFed >= peopleNumber){
            System.out.printf("Nobody left hungry. Meals left: %d\n",totalFed - peopleNumber);
        }else {
            System.out.printf("People are starving. Meals needed: %d\n", peopleNumber - totalFed);
        }
    }
}
