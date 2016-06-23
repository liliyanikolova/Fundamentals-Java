package com;

import java.util.Scanner;
import java.util.TreeSet;

public class _08_ExtractAllUniqueWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[^a-zA-Z]+");

        TreeSet<String> uniqueWords = new TreeSet<>();
        for (String element:input) {
            if (!uniqueWords.contains(element)){
                uniqueWords.add(element.toLowerCase());
            }
        }

        System.out.println(String.join(" ", uniqueWords));
    }
}

