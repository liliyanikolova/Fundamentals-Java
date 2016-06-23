package com;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _02_SortArrayWithStreamAPI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        String order = scanner.nextLine();
        if (order.equals("Ascending")){
            Arrays.sort(numbers);
        }else {
            Arrays.sort(numbers, Collections.reverseOrder());
        }

        System.out.println(String.join(" ", Arrays.stream(numbers).map(s -> s.toString()).toArray(String[]::new)));
    }
}