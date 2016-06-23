package com;

import java.util.Scanner;

public class _05_FromDecimalToBase7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = Integer.parseInt(scanner.nextLine());
        String numberTo7Base = Integer.toString(num, 7);

        System.out.println(numberTo7Base);
    }
}
