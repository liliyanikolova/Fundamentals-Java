package com;

import java.util.Scanner;
import java.util.Stack;

public class _09_StackFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        long result = getFibonacci(n);
        System.out.println(result);
    }

    public static long getFibonacci(int n){
        Stack<Integer> fibonacciElements = new Stack<>();

        fibonacciElements.push(1);
        fibonacciElements.push(1);
        for (int i = 1; i < n; i++) {
            int lastPush = fibonacciElements.pop();
            int newPush = fibonacciElements.peek() + lastPush;
            fibonacciElements.push(lastPush);
            fibonacciElements.push(newPush);
        }

        return fibonacciElements.peek();
    }
}
