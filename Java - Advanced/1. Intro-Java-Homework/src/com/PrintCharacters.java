package com;

public class PrintCharacters {

    public static void main(String[] args) {
        for (int i = 'a'; i < 'z'; i++) {
            char charForPrint = (char)i;
            System.out.print(charForPrint + " ");
        }
    }
}
