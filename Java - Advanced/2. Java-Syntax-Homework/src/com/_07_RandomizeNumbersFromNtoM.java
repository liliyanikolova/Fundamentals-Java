package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class _07_RandomizeNumbersFromNtoM {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int min;
        int max;
        if (m < n){
            min = m;
            max = n;
        }
        else {
            min = n;
            max = m;
        }


        List<String> resultList = new ArrayList<>();
        Integer diff = Math.abs(max - min);

        while (resultList.size() != diff + 1) {
            Random rand = new Random();
            Integer randomNumber = rand.nextInt(diff + 1) + min;
            if (resultList.contains(randomNumber.toString())){
                continue;
            }

            resultList.add(randomNumber.toString());
        }

        System.out.println(String.join(" ", resultList));
    }
}
