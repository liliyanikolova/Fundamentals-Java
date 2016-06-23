package com;

import java.util.Scanner;

public class _06_CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[^a-zA-Z]+");
        String targetWord = scanner.nextLine().toLowerCase();

        int targerWordCount = 0;
        for (String word:input) {
            if (word.toLowerCase().equals(targetWord)){
                targerWordCount++;
            }
        }

        System.out.println(targerWordCount);
    }
}
