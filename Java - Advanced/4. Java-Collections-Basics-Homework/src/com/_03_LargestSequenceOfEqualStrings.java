package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_LargestSequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        List<String> longestSequence = new ArrayList<>();
        longestSequence.add(input[0]);
        int maxCount = 1;

        List<String> currentSequence = new ArrayList<>();
        currentSequence.add(input[0]);
        int currentCount = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i - 1].equals(input[i])){
                currentCount++;
                currentSequence.add(input[i]);
            }else {
                if (currentCount > maxCount){
                    maxCount = currentCount;
                    longestSequence.clear();
                    for (String element:currentSequence) {
                        longestSequence.add(element);
                    }
                }
                currentCount = 1;
                currentSequence.clear();
                currentSequence.add(input[i]);
            }
        }

        if (currentCount > maxCount){
            longestSequence.clear();
            for (String element:currentSequence) {
                longestSequence.add(element);
            }
        }

        for (String element:longestSequence) {
            System.out.print(element + " ");
        }
    }
}
