package com;

import java.util.Scanner;

public class _02_SequencesOfEqualStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        System.out.print(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (input[i - 1].equals(input[i])){
                System.out.print(" " + input[i]);
            }else {
                System.out.print("\n" + input[i]);
            }
        }
    }
}
