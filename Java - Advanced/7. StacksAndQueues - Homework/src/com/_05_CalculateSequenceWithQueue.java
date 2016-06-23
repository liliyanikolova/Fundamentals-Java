package com;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _05_CalculateSequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.nextLine();

        System.out.print(n);
        Queue<Long> numbers = new ArrayDeque<>();
        Queue<Long> series = new ArrayDeque<>();
        for (int i = 1; i < 50; i++) {
            if (i % 3 == 1){
                numbers.add(n + 1);
                series.add(n +1);
            } else if(i % 3 == 2){
                numbers.add(2*n + 1);
                series.add(2*n +1);
            } else {
                numbers.add(n + 2);
                series.add(n + 2);
                n = series.poll();
            }
        }

        for (int i = 0; i < 49; i++) {
            System.out.print(" " + numbers.poll());
        }
    }
}
