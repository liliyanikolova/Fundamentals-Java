package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int numsToAdd = Integer.parseInt(input[0]);
        int numsToRemove = Integer.parseInt(input[1]);
        int targenNum = Integer.parseInt(input[2]);

        String[] inputNumbers = scanner.nextLine().split(" ");

        Queue<Integer> resultNumbers = new LinkedList<>();
        int minNumber = Integer.MAX_VALUE;
        for (int i = numsToRemove; i < numsToAdd; i++) {
            resultNumbers.add(Integer.parseInt(inputNumbers[i]));
            if (Integer.parseInt(inputNumbers[i]) < minNumber){
                minNumber = Integer.parseInt(inputNumbers[i]);
            }
        }

        if (resultNumbers.size() == 0){
            System.out.println(0);
        } else if (resultNumbers.contains(targenNum)){
            System.out.println(true);
        } else {
            System.out.println(minNumber);
        }
    }
}
