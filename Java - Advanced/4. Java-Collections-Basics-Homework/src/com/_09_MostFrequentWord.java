package com;

import java.util.*;

public class _09_MostFrequentWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("[^a-zA-Z]+");

        Map<String, Integer> wordsCount = new TreeMap<>();
        for (String element : input) {
            if (!wordsCount.containsKey(element.toLowerCase())) {
                wordsCount.put(element.toLowerCase(), 0);
            }

            wordsCount.put(element.toLowerCase(), wordsCount.get(element.toLowerCase()) + 1);
        }

        int maxCount = Collections.max(wordsCount.values());

        for (String word : wordsCount.keySet()) {
            if (wordsCount.get(word) == maxCount){
                System.out.println(word + " -> " + maxCount + " times");
            }
        }
    }
}
