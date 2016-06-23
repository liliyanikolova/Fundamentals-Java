package com;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class _10_CardsFrequencies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cards = scanner.nextLine().split(" ");

        LinkedHashMap<Character, Integer> cardsByCount = new LinkedHashMap<>();
        for (String card : cards) {
            if (!cardsByCount.containsKey(card.charAt(0))){
                cardsByCount.put(card.charAt(0), 0);
            }

            cardsByCount.put(card.charAt(0), cardsByCount.get(card.charAt(0)) + 1);
        }

        for (Character card : cardsByCount.keySet()) {
                System.out.println(String.format("%c -> %.2f%% times", card, ((double)cardsByCount.get(card) / cards.length) * 100));
        }
    }
}
