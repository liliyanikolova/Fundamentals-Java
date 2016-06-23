package com;

import java.util.Scanner;
import java.util.Stack;

public class _01_ReverseNumbersWithStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < input.length; i++) {
            System.out.print(numbers.pop() + " ");
        }
        System.out.println();
    }
}
