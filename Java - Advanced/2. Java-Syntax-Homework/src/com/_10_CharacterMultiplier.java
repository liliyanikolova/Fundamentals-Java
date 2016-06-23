package com;

import java.util.Scanner;

public class _10_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        long output = multiplyCharacter(input[0], input[1]);
        System.out.println(output);
    }

    public static long multiplyCharacter(String str1, String str2) {
        long result = 0;
        String shorterStr = "";
        String longerStr = "";
        if (str1.length() > str2.length()) {
            shorterStr = str2;
            longerStr = str1;
        } else {
            shorterStr = str1;
            longerStr = str2;
        }

        for (int i = 0; i < shorterStr.length(); i++) {
            result += str1.charAt(i) * str2.charAt(i);
        }

        for (int i = shorterStr.length(); i < longerStr.length(); i++) {
            result += longerStr.charAt(i);
        }

        return result;
    }
}
