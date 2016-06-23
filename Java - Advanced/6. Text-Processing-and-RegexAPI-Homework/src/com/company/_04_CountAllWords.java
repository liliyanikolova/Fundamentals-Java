package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04_CountAllWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchText = scanner.nextLine();
        Pattern pattern = Pattern.compile("([a-zA-Z])+");
        Matcher matcher = pattern.matcher(searchText);

        int counter = 0;
        while (matcher.find()){
            counter++;
        }

        System.out.println(counter);
    }
}
