package com;

import java.util.Scanner;

public class _02_TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pointA = scanner.nextLine().split(" ");
        String[] pointB = scanner.nextLine().split(" ");
        String[] pointC = scanner.nextLine().split(" ");

        int pointAx = Integer .parseInt(pointA[0]);
        int pointAy = Integer.parseInt(pointA[1]);
        int pointBx = Integer .parseInt(pointB[0]);
        int pointBy = Integer.parseInt(pointB[1]);
        int pointCx = Integer .parseInt(pointC[0]);
        int pointCy = Integer.parseInt(pointC[1]);

        double area = Math.round(Math.abs((double)(pointAx*(pointBy - pointCy) + pointBx*(pointCy - pointAy) + pointCx*(pointAy - pointBy))/2));

        System.out.printf("%.0f", area);
    }
}
