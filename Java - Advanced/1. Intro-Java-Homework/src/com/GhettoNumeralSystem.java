package com;

import java.util.Scanner;

public class GhettoNumeralSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            switch (num.substring(i, i + 1))
            {
                case "0":
                    output.append("Gee");
                    break;
                case "1":
                    output.append("Bro");
                    break;
                case "2":
                    output.append("Zuz");
                    break;
                case "3":
                    output.append("Ma");
                    break;
                case "4":
                    output.append("Duh");
                    break;
                case "5":
                    output.append("Yo");
                    break;
                case "6":
                    output.append("Dis");
                    break;
                case "7":
                    output.append("Hood");
                    break;
                case "8":
                    output.append("Jam");
                    break;
                case "9":
                    output.append("Mack");
                    break;
                case ".":
                    output.append(".");
                    break;
            }
        }

        System.out.println(output.toString());
    }
}
