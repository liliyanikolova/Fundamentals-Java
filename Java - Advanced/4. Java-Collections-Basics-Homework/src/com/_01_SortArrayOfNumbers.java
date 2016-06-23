package com;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_SortArrayOfNumbers {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = Arrays.stream(input).map(num -> Integer.parseInt(num)).sorted().collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
