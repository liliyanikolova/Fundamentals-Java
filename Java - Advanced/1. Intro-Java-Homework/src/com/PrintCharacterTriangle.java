package com;

import java.io.IOException;
import java.util.Scanner;

public class PrintCharacterTriangle {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        int input = console.nextInt();
        int maxValue = (int)'a' + input;
        for (char i = 'a'; i < maxValue; i++) {
            for (char j = 'a'; j < i + 1; j++) {
                int dif = (int)j % 26;
                char printeeChar = (char)('a' + dif);
                System.out.print(printeeChar + " ");
            }
            System.out.println();
        }

        for (char i = (char)(maxValue - 1); i > 'a'; i--) {
            for (char j = 'a'; j < i; j++) {
                int dif = (int)j % 26;
                char printeeChar = (char)('a' + dif);
                System.out.print(printeeChar + " ");
            }
            System.out.println();
        }
    }
}
