package com;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_RoyalFlush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        StringBuilder allCards = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            allCards.append(input);
        }

        String list = allCards.toString().replace("J","11").replace("Q", "12").replace("K", "13").replace("A", "14");
        Pattern pattern = Pattern.compile("([0-9]{1,2})([cdhs])");
        Matcher matcher = pattern.matcher(list);

        long royalFlushCount = 0;
        ArrayList<Integer> royalFlushC = new ArrayList<>();
        ArrayList<Integer> royalFlushD = new ArrayList<>();
        ArrayList<Integer> royalFlushH = new ArrayList<>();
        ArrayList<Integer> royalFlushS = new ArrayList<>();
        while (matcher.find()) {
            int card = Integer.parseInt(matcher.group(1));
            String face = matcher.group(2);

            if (card >= 10){
                switch (face){
                    case "c":
                        if (royalFlushC.size() == 0){
                            royalFlushC.add(card);
                        } else {
                            if (card > royalFlushC.get(royalFlushC.size() - 1)){
                                royalFlushC.add(card);
                                if (royalFlushC.size() == 5){
                                    System.out.println("Royal Flush Found - Clubs");
                                    royalFlushCount++;
                                    royalFlushC.clear();
                                }
                            }else {
                                royalFlushC.clear();
                                royalFlushC.add(card);
                            }
                        }
                        break;
                    case "d":
                        if (royalFlushD.size() == 0){
                            royalFlushD.add(card);
                        } else {
                            if (card > royalFlushD.get(royalFlushD.size() - 1)){
                                royalFlushD.add(card);
                                if (royalFlushD.size() == 5){
                                    System.out.println("Royal Flush Found - Diamonds");
                                    royalFlushCount++;
                                    royalFlushD.clear();
                                }
                            }else {
                                royalFlushD.clear();
                                royalFlushD.add(card);
                            }
                        }
                        break;
                    case "h":
                        if (royalFlushH.size() == 0){
                            royalFlushH.add(card);
                        } else {
                            if (card > royalFlushH.get(royalFlushH.size() - 1)){
                                royalFlushH.add(card);
                                if (royalFlushH.size() == 5){
                                    System.out.println("Royal Flush Found - Hearts");
                                    royalFlushCount++;
                                    royalFlushH.clear();
                                }
                            }else {
                                royalFlushH.clear();
                                royalFlushH.add(card);
                            }
                        }
                        break;
                    case "s":
                        if (royalFlushS.size() == 0){
                            royalFlushS.add(card);
                        } else {
                            if (card > royalFlushS.get(royalFlushS.size() - 1)){
                                royalFlushS.add(card);
                                if (royalFlushS.size() == 5){
                                    System.out.println("Royal Flush Found - Spades");
                                    royalFlushCount++;
                                    royalFlushS.clear();
                                }
                            }else {
                                royalFlushS.clear();
                                royalFlushS.add(card);
                            }
                        }
                        break;
                }
            }
        }

        System.out.println("Royal's Royal Flushes - " + royalFlushCount + ".");
    }
}
