package com;

import java.util.Scanner;

public class _01_MelrahShake_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String pattern = scanner.nextLine();

        while (input.length() != 0 && pattern.length() != 0){
            StringBuilder result = new StringBuilder(input);
            int firstIndex = result.indexOf(pattern);
            int lastIndex = result.lastIndexOf(pattern);
            if (firstIndex != lastIndex){
                result.replace(lastIndex, lastIndex + pattern.length(), "");
                result.replace(firstIndex, firstIndex + pattern.length(), "");

                System.out.println("Shaked it.");
            } else {
                input = result.toString();
                break;
            }

            input = result.toString();

            StringBuilder newPattern = new StringBuilder(pattern);
            newPattern.replace(pattern.length() / 2, pattern.length() / 2 + 1, "");
            pattern = newPattern.toString();
        }

        System.out.println("No shake.");
        System.out.println(input);
    }
}
