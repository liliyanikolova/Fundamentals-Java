package com;

public class GetAverage {
    public static void main(String[] args) {
        System.out.println(String.format("%.2f", getAverage(1.5, 2.5, 3.8)));
        System.out.println(String.format("%.2f", getAverage(12, 13, 25)));
        System.out.println(String.format("%.2f", getAverage(0.005, 0.5, 0.55)));
        System.out.println(String.format("%.2f", getAverage(0, 0, 2)));
    }

    public static double getAverage(double num1, double num2, double num3){
        return  (num1 + num2 + num3) / 3;
    }
}
