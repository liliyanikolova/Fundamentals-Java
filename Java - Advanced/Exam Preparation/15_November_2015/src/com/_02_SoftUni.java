package com;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_SoftUni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.lang.String input = scanner.nextLine();

        while (!input.equals("OK KoftiShans")){
            Pattern pat = Pattern.compile("([A-Z][a-z]+)[^A-Za-z]*([A-Z][a-z]+[A-Z])[^A-Za-z]*[^0-9]+(\\d+L)");
            Matcher matcher = pat.matcher(input);
            while (matcher.find()){
                Double drinkAmount = Double.parseDouble(matcher.group(3).substring(0, matcher.group(3).indexOf('L') - 1));
                System.out.printf("%s brought %d liters of %s!", matcher.group(1), drinkAmount, matcher.group(2));
            }

            input = scanner.nextLine();
        }
    }
}
