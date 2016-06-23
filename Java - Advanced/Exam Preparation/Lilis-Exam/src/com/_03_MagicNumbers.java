package com;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_MagicNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s+");

        List<String> magicNumbers = new ArrayList<>();
        int lastDigitsSum = 0;
        for (String number : numbers) {
            int firstDigit = Integer.parseInt(Character.toString(number.charAt(0)));
            int secondDigit = Integer.parseInt(Character.toString(number.charAt(1)));
            int thirdDigit = Integer.parseInt(Character.toString(number.charAt(2)));
            if (firstDigit + secondDigit == thirdDigit){
                magicNumbers.add(number);
                lastDigitsSum += thirdDigit;
            }
        }

        if (magicNumbers.size() == 0){
            System.out.println("No magic numbers.");
            return;
        }

        System.out.println(String.join(" ", magicNumbers));
        if (magicNumbers.size() == numbers.length){
            System.out.println(factorial(lastDigitsSum));
        }
    }

    public static BigInteger factorial(int n){
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
