package com;

import java.util.Scanner;

public class SumNumbersFrom1toN {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        long num = Long.parseLong(scaner.nextLine());
        long sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }

        System.out.print(sum);
    }
}
