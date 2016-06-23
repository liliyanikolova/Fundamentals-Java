package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_StartsAndEndsWithCapitalLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchText = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b([A-Z][a-zA-Z]*[A-Z])\\b");
        Matcher matcher = pattern.matcher(searchText);

        while (matcher.find()){
            System.out.print(matcher.group(0) + " ");
        }

        System.out.println();
    }
}
