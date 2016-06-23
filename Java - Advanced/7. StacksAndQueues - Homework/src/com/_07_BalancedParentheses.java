package com;

import java.util.Scanner;
import java.util.Stack;

public class _07_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String paranhesis = scanner.nextLine();

        if (paranhesis.length() % 2 == 1){
            System.out.println("NO");
            return;
        }

        Stack<Character> leftHaf = new Stack<>();
        for (int i = 0; i < paranhesis.length()/2; i++) {
            switch (paranhesis.charAt(i)){
                case '{':
                    leftHaf.add('}');
                    break;
                case '[':
                    leftHaf.add(']');
                    break;
                case '(':
                    leftHaf.add(')');
                    break;
                case '}':
                    leftHaf.add('{');
                    break;
                case ']':
                    leftHaf.add('[');
                    break;
                case ')':
                    leftHaf.add('(');
                    break;
            }
        }

        for (int i = paranhesis.length()/2; i < paranhesis.length(); i++) {
            if (paranhesis.charAt(i) != leftHaf.pop()){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
