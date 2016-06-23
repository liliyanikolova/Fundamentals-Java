package com;

import java.util.Scanner;

public class _08_OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        if (input.length % 2 != 0){
            System.out.println("Invalid length");
            return;
        }

        for (int i = 0; i < input.length; i += 2) {
            System.out.print(input[i] + ", " +input[i + 1] + " -> ");
            if ((Integer.parseInt(input[i]) % 2) == (Integer.parseInt(input[i + 1]) % 2)){
                if (Integer.parseInt(input[i]) % 2 == 0){
                    System.out.println("both are even");
                } else {
                    System.out.println("both are odd");
                }
            } else {
                System.out.println("different");
            }
        }
    }
}
