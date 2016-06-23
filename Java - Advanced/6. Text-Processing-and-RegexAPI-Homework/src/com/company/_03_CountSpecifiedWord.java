package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchText = scanner.nextLine().toLowerCase();
        String regex = scanner.nextLine().toLowerCase();
        Pattern pattern = Pattern.compile("\\b" + regex + "\\b");
        Matcher matcher = pattern.matcher(searchText);

        int counter = 0;
        while (matcher.find()){
            counter++;
        }

        System.out.println(counter);
    }
}
