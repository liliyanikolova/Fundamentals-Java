package com;

import java.util.Scanner;

public class _01_TheGrammarTeacher {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = scanner.nextLine().split(",");

        StringBuilder result = new StringBuilder(input);
        int spaceCounter = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == ' '){
                result.replace(i, i + 1, " " + words[spaceCounter]);
                i += words[spaceCounter].length();
                spaceCounter++;
            }
        }

        System.out.println(result.toString());
    }
}
