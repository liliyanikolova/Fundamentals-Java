package com;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lili on 4/5/2016.
 */
public class test {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        List<Integer> inputList = new ArrayList<>();
        String command = console.nextLine();

        for (int i = 0; i < input.length; i++) {
            inputList.add(Integer.parseInt(input[i]));
        }

        if (command.equals("Ascending")) {
            Stream<Integer> numbers = inputList.stream().sorted(Comparator.naturalOrder());
            numbers.forEach(e -> System.out.print(e + " "));
        } else {
            Stream<Integer> numbers = inputList.stream().sorted(Comparator.reverseOrder());
            numbers.forEach(e -> System.out.print(e + " "));
        }
    }
}
