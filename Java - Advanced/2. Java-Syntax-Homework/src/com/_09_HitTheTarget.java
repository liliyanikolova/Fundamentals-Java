package com;

import java.util.Scanner;

public class _09_HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer target = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == target){
                    System.out.println(String.format("%d + %d = %d", i, j, target));
                }
            }
        }

        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i - j == target){
                    System.out.println(String.format("%d - %d = %d", i, j, target));
                }
            }
        }
    }
}
