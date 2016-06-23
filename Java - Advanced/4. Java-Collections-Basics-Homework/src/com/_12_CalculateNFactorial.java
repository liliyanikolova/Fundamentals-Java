package com;

import java.util.Scanner;

public class _12_CalculateNFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(calculateFactorial(n));
    }

    private static int calculateFactorial(int n){
        if (n < 1){
            return 1;
        }

        return n * calculateFactorial(n - 1);
    }
}
