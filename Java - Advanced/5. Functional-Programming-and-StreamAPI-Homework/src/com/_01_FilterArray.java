package com;

import java.util.Arrays;
import java.util.Scanner;

public class _01_FilterArray {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String[] output = Arrays.stream(input).filter(s -> s.length() > 3).toArray(String[]::new);
        if (output.length > 0){
            System.out.println(String.join(" ", output));
        }else {
            System.out.println("(empty)");
        }

    }
}
