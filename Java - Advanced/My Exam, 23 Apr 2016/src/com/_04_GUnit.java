package com;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _04_GUnit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> classDatabase = new LinkedHashMap<>();

        while (!input.equals("It's testing time!")){
            Pattern pattern = Pattern.compile("^([A-Z][A-Za-z0-9]+)\\s\\|\\s([A-Z][A-Za-z0-9]+)\\s\\|\\s([A-Z][A-Za-z0-9]+)$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String className = matcher.group(1);
                String methodName = matcher.group(2);
                String testName = matcher.group(3);
                if (!classDatabase.containsKey(className)){
                    classDatabase.put(className, new LinkedHashMap<>());
                }

                if (!classDatabase.get(className).containsKey(methodName)){
                    ArrayList<String> unitTests = new ArrayList<>();
                    unitTests.add(testName);
                    classDatabase.get(className).put(methodName, unitTests);
                }

                if (!classDatabase.get(className).get(methodName).contains(testName)){
                    classDatabase.get(className).get(methodName).add(testName);
                }
            }

            input = scanner.nextLine();
        }

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> sortedClassDatabase = classDatabase.entrySet()
                .stream()
                .sorted((firstClass, secondClass) -> {
                    return firstClass.getKey().compareTo(secondClass.getKey());
                })
                .sorted((firstClass, secondClass) -> {
                    Integer firstMethodsCount = firstClass.getValue().size();
                    Integer secondMethodsCount = secondClass.getValue().size();

                    return firstMethodsCount.compareTo(secondMethodsCount);
                })
                .sorted((firstClass, secondClass) -> {
                    Integer firstClassUnitTestsCount = 0;
                    for (Map.Entry<String,ArrayList<String>> methodEntry : firstClass.getValue().entrySet()) {
                        firstClassUnitTestsCount += methodEntry.getValue().size();
                    }

                    Integer secondClassUnitTestsCount = 0;
                    for (Map.Entry<String,ArrayList<String>> methodEntry : secondClass.getValue().entrySet()) {
                        secondClassUnitTestsCount += methodEntry.getValue().size();
                    }

                    return secondClassUnitTestsCount.compareTo(firstClassUnitTestsCount);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y)-> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        for (Map.Entry<String,LinkedHashMap<String,ArrayList<String>>> classEntry : sortedClassDatabase.entrySet()) {
            System.out.println(classEntry.getKey() + ":");
            LinkedHashMap<String, ArrayList<String>> sortedMethods = classEntry.getValue().entrySet()
                    .stream()
                    .sorted((fisrtMethod, secondMethod) -> {
                        return fisrtMethod.getKey().compareTo(secondMethod.getKey());
                    })
                    .sorted((fisrtMethod, secondMethod) -> {
                        Integer firstMethodTestsCount = fisrtMethod.getValue().size();
                        Integer secondMethodTestsCount = secondMethod.getValue().size();

                        return secondMethodTestsCount.compareTo(firstMethodTestsCount);
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x,y)-> {throw new AssertionError();},
                            LinkedHashMap::new
                    ));

            for (Map.Entry<String,ArrayList<String>> methodEntry : sortedMethods.entrySet()) {
                System.out.println("##" + methodEntry.getKey());

                Comparator<String> x = (o1, o2) -> {
                    if(o1.length() < o2.length())
                        return -1;

                    if(o2.length() > o1.length())
                        return 1;

                    return 0;
                };

                Collections.sort(methodEntry.getValue());
                Collections.sort(methodEntry.getValue(),  x);

                for (String test : methodEntry.getValue()) {
                    System.out.println("####" + test);
                }
            }
        }
    }
}
