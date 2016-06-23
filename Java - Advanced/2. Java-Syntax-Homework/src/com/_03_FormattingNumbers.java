package com;

import java.util.Scanner;

public class _03_FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int a = Integer.parseInt(input[0]);
        double b = Double.parseDouble(input[1]);
        double c = Double.parseDouble(input[2]);

        System.out.print("|" + String.format("%-10X", a));
        System.out.print("|" + String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0"));
        System.out.print("|" + String.format("%10.2f", b));
        System.out.print("|" + String.format("%-10.3f", c) + "|");
    }
}
