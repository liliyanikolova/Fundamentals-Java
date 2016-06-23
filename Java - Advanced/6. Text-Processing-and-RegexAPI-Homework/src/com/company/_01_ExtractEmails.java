package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_ExtractEmails {

    public static void main(String[] args) {
        String regex = "([a-zA-Z0-9]+[\\.\\-\\_]?[a-zA-Z0-9]+)\\@([a-zA-Z]+[\\-]?[a-zA-Z])(\\.[a-zA-Z]+)+";
        Pattern emailPattern = Pattern.compile(regex);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Matcher matcher = emailPattern.matcher(input);

        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
