package com;

        import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;
        import java.util.stream.Collectors;

public class _04_LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> materials = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);
        keyMaterials.put("motes", 0);
        String winMaterial = "";
        while (scanner.hasNextLine()) {
            String[] input = scanner.nextLine().split("\\s+");
            boolean stopLoop = false;
            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250) {
                        winMaterial = material;
                        stopLoop = true;
                        break;
                    }
                } else {
                    if (!materials.containsKey(material)) {
                        materials.put(material, 0);
                    }

                    materials.put(material, materials.get(material) + quantity);
                }
            }

            if (stopLoop){
                break;
            }
        }

        switch (winMaterial){
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }

        keyMaterials.put(winMaterial, keyMaterials.get(winMaterial) - 250);
        LinkedHashMap<String, Integer> sortedKeyMaterials = keyMaterials.entrySet()
                .stream()
                .sorted((firstMaterial, secondMaterial) -> {
                    int result = secondMaterial.getValue().compareTo(firstMaterial.getValue());
                    if (result == 0) {
                        result = firstMaterial.getKey().compareTo(secondMaterial.getKey());
                    }

                    return result;
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, Integer> keyMaterialEntry : sortedKeyMaterials.entrySet()) {
            System.out.println(keyMaterialEntry.getKey() + ": " + keyMaterialEntry.getValue());
        }

        LinkedHashMap<String, Integer> sortedMaterials = materials.entrySet()
                .stream()
                .sorted((firstMaterial, secondMaterial) -> firstMaterial.getKey().compareTo(secondMaterial.getKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, Integer> keyMaterialEntry : sortedMaterials.entrySet()) {
            System.out.println(keyMaterialEntry.getKey() + ": " + keyMaterialEntry.getValue());
        }
    }
}
