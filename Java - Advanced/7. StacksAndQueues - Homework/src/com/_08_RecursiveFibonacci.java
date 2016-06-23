package com;

import java.util.Scanner;

public class _08_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.hasNextLine();

        long result = getFibonacci(num);
        System.out.println(result);
    }

    public static long getFibonacci(int num){
        if (num <= 1){
            return 1;
        }

        return getFibonacci(num - 1) + getFibonacci(num - 2);
    }
}
