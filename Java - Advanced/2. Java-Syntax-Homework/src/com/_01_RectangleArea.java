package com;

import java.util.Scanner;

public class _01_RectangleArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rectageSides = scanner.nextLine().split(" ");
        int sideA = Integer .parseInt(rectageSides[0]);
        int sideB = Integer.parseInt(rectageSides[1]);
        int area = sideA *  sideB;
        System.out.println(area);
    }
}
