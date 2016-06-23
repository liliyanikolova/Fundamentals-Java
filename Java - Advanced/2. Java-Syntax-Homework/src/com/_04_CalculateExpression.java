package com;

import java.util.Scanner;

public class _04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        double a = Double.parseDouble(numbers[0]);
        double b = Double.parseDouble(numbers[1]);
        double c = Double.parseDouble(numbers[2]);

        double f1 = Math.pow((Math.pow(a, 2) + Math.pow(b, 2))/(Math.pow(a, 2) - Math.pow(b, 2)), (a + b + c)/ Math.sqrt(c));
        double f2 = Math.pow(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3), a - b);
        double diff = Math.abs((a + b + c) / 3 - (f1 + f2) / 2);

        System.out.printf("F1 result: %.2f; ", f1);
        System.out.printf("F2 result: %.2f; ", f2);
        System.out.printf("Diff: %.2f; ", diff);
    }
}
