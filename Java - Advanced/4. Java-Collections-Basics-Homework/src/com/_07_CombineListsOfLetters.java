package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_CombineListsOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(s -> s.charAt(0)).collect(Collectors.toCollection(ArrayList<Character>::new));
        ArrayList<Character> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(s -> s.charAt(0)).collect(Collectors.toCollection(ArrayList<Character>::new));

        for (Character element:secondList) {
            if (!firstList.contains(element)){
                firstList.add(element);
            }
        }

        for (int i = 0; i < firstList.size(); i++) {
            System.out.print(firstList.get(i) + " ");
        }
        System.out.println();
    }
}
