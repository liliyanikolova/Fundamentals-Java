package com;

import java.util.Scanner;

public class _06_FromBase7toDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int numberTo10Base = Integer.parseInt(num, 7);

        System.out.println(numberTo10Base);
    }
}
