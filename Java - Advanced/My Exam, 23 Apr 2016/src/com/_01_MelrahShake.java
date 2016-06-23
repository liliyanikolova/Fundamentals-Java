package com;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_MelrahShake {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String pattern = scanner.nextLine();

        while (input.length() != 0){
            Pattern pat = Pattern.compile(pattern);
            Matcher matcher = pat.matcher(input);

            if (!matcher.find() || matcher.group().length() < 2 || pattern.length() == 0){
                System.out.println("No shake.");
                System.out.println(input);
                break;
            }

            StringBuilder result = new StringBuilder();
            StringBuilder reversedPatern = new StringBuilder();

            if (matcher.find()){
                if (matcher.group().length() >= 2){
                    result.append(input.replaceFirst(pattern, ""));
                    input = result.reverse().toString();
                    result.delete(0, result.length());
                    reversedPatern.append(pattern).reverse();
                    result.append(input.replaceFirst(reversedPatern.toString(), ""));
                    result.reverse();
                    input = result.toString();

                    System.out.println("Shaked it.");

                    pattern = pattern.substring(0, pattern.length() / 2) + pattern.substring(pattern.length() / 2 + 1, pattern.length());
                }
            }
        }
    }
}
