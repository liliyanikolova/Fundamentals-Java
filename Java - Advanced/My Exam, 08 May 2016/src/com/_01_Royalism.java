package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_Royalism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int royalistsCount = 0;
        int nonRoyalistsCount = 0;
        List<String> royalists = new ArrayList<>();
        List<String> nonRoyalists = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            int currentSum = 0;
            for (int ch = 0; ch < input[i].length(); ch++) {
                currentSum += input[i].charAt(ch);
                while (currentSum > 26){
                    currentSum -= 26;
                }
            }

            if (currentSum == 18){
                royalistsCount++;
                royalists.add(input[i]);
            } else {
                nonRoyalistsCount++;
                nonRoyalists.add(input[i]);
            }
        }

        if (royalistsCount >= nonRoyalistsCount){
            System.out.printf("Royalists - %d\n", royalistsCount);
            for (String royalist : royalists) {
                System.out.println(royalist);
            }

            System.out.println("All hail Royal!");
        } else {
            for (String nonRoyalist : nonRoyalists) {
                System.out.println(nonRoyalist);
            }
            System.out.printf("Royalism, Declined!");
        }
    }
}
