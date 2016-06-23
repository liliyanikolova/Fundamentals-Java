package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_LongestIncreasingSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(n -> Integer.parseInt(n)).collect(Collectors.toList());

        List<Integer> longestSequence = new ArrayList<>();
        longestSequence.add(nums.get(0));
        int maxCount = 1;

        List<Integer> currentSequence = new ArrayList<>();
        currentSequence.add(nums.get(0));
        int currentCount = 1;
        System.out.print(nums.get(0));

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)){
                System.out.print(" " + nums.get(i));
                currentSequence.add(nums.get(i));
                currentCount++;
            }else {
                if (currentCount > maxCount){
                    maxCount = currentCount;
                    longestSequence.clear();
                    for (int element:currentSequence) {
                        longestSequence.add(element);
                    }
                }
                System.out.println();
                System.out.print(nums.get(i));
                currentCount = 1;
                currentSequence.clear();
                currentSequence.add(nums.get(i));
            }
        }

        if (currentCount > maxCount){
            longestSequence.clear();
            for (int element:currentSequence) {
                longestSequence.add(element);
            }
        }

        System.out.println();
        System.out.print("Longest: ");
        for (int element:longestSequence) {
            System.out.print(element + " ");
        }
    }
}
