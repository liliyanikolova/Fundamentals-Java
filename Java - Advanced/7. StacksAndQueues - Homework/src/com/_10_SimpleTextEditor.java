package com;

import java.util.Scanner;
import java.util.Stack;

public class _10_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        StringBuilder resultText = new StringBuilder();
        Stack<String> strs = new Stack<>();
        strs.push("");
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]){
                case "1":
                    resultText.append(command[1]);
                    strs.push(resultText.toString());
                    break;
                case "2":
                    resultText.replace(resultText.length() - Integer.parseInt(command[1]), resultText.length(), "");
                    strs.push(resultText.toString());
                    break;
                case "3":
                    System.out.println(resultText.charAt(Integer.parseInt(command[1]) - 1));
                    break;
                case "4":
                    strs.pop();
                    resultText.replace(0, resultText.length(), strs.peek());
                    break;
            }
        }
    }
}
