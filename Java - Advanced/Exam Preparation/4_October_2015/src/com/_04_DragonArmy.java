package com;

import java.util.*;

public class _04_DragonArmy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dragonsCount = scanner.nextInt();
        scanner.nextLine();

        LinkedHashMap<String, TreeMap<String, ArrayList<Integer>>> dragonsByType = new LinkedHashMap<>();
        for (int i = 0; i < dragonsCount; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int damage = 45;
            int health = 250;
            int armor = 10;
            if (!input[2].equals("null")){
                damage = Integer.parseInt(input[2]);
            }

            if (!input[3].equals("null")){
                health = Integer.parseInt(input[3]);
            }

            if (!input[4].equals("null")){
                armor = Integer.parseInt(input[4]);
            }

            if (!dragonsByType.containsKey(type)){
                dragonsByType.put(type, new TreeMap<>());
            }

            if (!dragonsByType.get(type).containsKey(name)){
                dragonsByType.get(type).put(name, new ArrayList<>());
            }

            dragonsByType.get(type).get(name).clear();
            dragonsByType.get(type).get(name).add(damage);
            dragonsByType.get(type).get(name).add(health);
            dragonsByType.get(type).get(name).add(armor);
        }

        for (Map.Entry<String,TreeMap<String,ArrayList<Integer>>> typeEntry : dragonsByType.entrySet()) {
            double sumDamage = 0;
            double sumHealth = 0;
            double sumArmor = 0;
            int dragonsNameCount = 0;

            for (Map.Entry<String,ArrayList<Integer>> dragonNameEntry : typeEntry.getValue().entrySet()) {
                sumDamage += dragonNameEntry.getValue().get(0);
                sumHealth += dragonNameEntry.getValue().get(1);
                sumArmor += dragonNameEntry.getValue().get(2);
                dragonsNameCount++;
            }

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",
                    typeEntry.getKey(),
                    sumDamage / dragonsNameCount,
                    sumHealth / dragonsNameCount,
                    sumArmor / dragonsNameCount);

            for (Map.Entry<String,ArrayList<Integer>> dragonNameEntry : typeEntry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        dragonNameEntry.getKey(),
                        dragonNameEntry.getValue().get(0),
                        dragonNameEntry.getValue().get(1),
                        dragonNameEntry.getValue().get(2));
            }
        }
    }
}
