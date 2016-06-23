package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lili on 4/8/2016.
 */
public class Temp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-zA-Z]*[A-Z]\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
