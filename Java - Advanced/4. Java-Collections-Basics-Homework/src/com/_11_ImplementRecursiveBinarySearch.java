package com;

import java.util.Arrays;
import java.util.Scanner;

public class _11_ImplementRecursiveBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(n -> Integer.parseInt(n)).toArray(size -> new Integer[size]);

        System.out.println(returnIndex(target, numbers, 0, numbers.length - 1));
    }

    private static int returnIndex(int target, Integer[] numbers, int start, int end){
        int middle = (start + end) / 2;
        if (end < start){
            return -1;
        }

        if (target == numbers[middle]) {
            return middle;
        }
        else if (target < numbers[middle]) {
            return returnIndex(target, numbers, start, middle - 1);
        }
        else {
            return returnIndex(target, numbers, middle + 1, end);
        }
    }
}
