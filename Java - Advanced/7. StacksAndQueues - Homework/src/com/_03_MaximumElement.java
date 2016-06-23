package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class _03_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCommands = Integer.parseInt(reader.readLine());

        Stack<Integer> result = new Stack<>();
        Stack<Integer> maxElements = new Stack<>();
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < numCommands; i++) {
            String[] currentCommand = reader.readLine().split(" ");
            switch (currentCommand[0]){
                case "1":
                    result.add(Integer.parseInt(currentCommand[1]));
                    if (result.peek() > maxElement){
                        maxElement = result.peek();
                        maxElements.add(maxElement);
                    }

                    break;
                case "2":
                    int deletedNum = result.pop();
                    if (deletedNum == maxElement){
                        maxElements.pop();
                        maxElement = maxElements.peek();
                    }

                    break;
                case "3":
                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
