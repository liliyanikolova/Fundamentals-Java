package com;

import java.util.Scanner;
import java.util.Stack;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nsx = scanner.nextLine().split(" ");
        String[] inputNumbers = scanner.nextLine().split(" ");

        int numsToPop = Integer.parseInt(nsx[1]);
        int wantedElement = Integer.parseInt(nsx[2]);

        Stack<Integer> resultList = new Stack<>();
        int minNum = Integer.parseInt(inputNumbers[0]);
        for (int i = 0; i < inputNumbers.length - numsToPop; i++) {
            resultList.add(Integer.parseInt(inputNumbers[i]));
            if (resultList.peek() < minNum){
                minNum = resultList.peek();
            }
        }

        if (resultList.size() == 0){
            System.out.println(0);
        } else if  (resultList.contains(wantedElement)){
            System.out.println("true");
        } else {
            System.out.println(minNum);
        }
    }
}
