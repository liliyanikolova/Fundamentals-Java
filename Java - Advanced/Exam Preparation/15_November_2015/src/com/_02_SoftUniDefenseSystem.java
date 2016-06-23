package com;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_SoftUniDefenseSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Integer totalLitters = 0;
        while (!input.equals("OK KoftiShans")){
            Pattern pat = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+L)");
            Matcher matcher = pat.matcher(input);
            while (matcher.find()){
                Integer drinkAmount = Integer.parseInt(matcher.group(3).substring(0, matcher.group(3).indexOf('L')));
                System.out.printf("%s brought %d liters of %s!\n", matcher.group(1), drinkAmount, matcher.group(2).toLowerCase());
                totalLitters += drinkAmount;
            }

            input = scanner.nextLine();
        }

        System.out.printf("%.3f softuni liters", totalLitters * 0.001);
        System.out.println();
    }
}
