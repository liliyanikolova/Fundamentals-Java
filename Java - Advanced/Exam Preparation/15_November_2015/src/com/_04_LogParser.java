package com;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _04_LogParser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, TreeMap<String, ArrayList<String>>> logDatabase = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String regex = "\\{\"Project\":\\s+\\[\"(.+)\"\\],\\s+\"Type\":\\s+\\[\"(Critical|Warning)\"\\],\\s+\"Message\":\\s+\\[\"(.+)\"\\]\\}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String projectName = matcher.group(1);
                String logType = matcher.group(2);
                String logMessage = matcher.group(3);

                if (!logDatabase.containsKey(projectName)) {
                    logDatabase.put(projectName, new TreeMap<>());
                    logDatabase.get(projectName).put("Critical", new ArrayList<>());
                    logDatabase.get(projectName).put("Warning", new ArrayList<>());
                }

                if (logType.equals("Critical")) {
                    logDatabase.get(projectName).get("Critical").add(logMessage);
                } else {
                    logDatabase.get(projectName).get("Warning").add(logMessage);
                }
            }

            input = scanner.nextLine();
        }

        LinkedHashMap<String, TreeMap<String, ArrayList<String>>> sortedProjects =
                logDatabase.entrySet()
                        .stream()
                        .sorted((firstPrject, secondProject) -> {
                            return firstPrject.getKey().compareTo(secondProject.getKey());
                        })
                        .sorted((firstPrject, secondProject) -> {
                            Integer firstProjectLogsCount = 0;
                            Integer secondProjectLogsCount = 0;
                            for (Map.Entry<String, ArrayList<String>> projectEntry : firstPrject.getValue().entrySet()) {
                                firstProjectLogsCount += projectEntry.getValue().size();
                            }

                            for (Map.Entry<String, ArrayList<String>> projectEntry : secondProject.getValue().entrySet()) {
                                secondProjectLogsCount += projectEntry.getValue().size();
                            }

                            return secondProjectLogsCount.compareTo(firstProjectLogsCount);
                        })
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x, y) -> {
                                    throw new AssertionError();
                                },
                                LinkedHashMap::new
                        ));

        for (Map.Entry<String,TreeMap<String,ArrayList<String>>> stringTreeMapEntry : sortedProjects.entrySet()) {

        }

        int currentProjecCount = 0;
        for (Map.Entry<String, TreeMap<String, ArrayList<String>>> projectEntry : sortedProjects.entrySet()) {
            System.out.printf("%s:\n", projectEntry.getKey());
            Integer totalErrors = 0;
            for (Map.Entry<String, ArrayList<String>> project : projectEntry.getValue().entrySet()) {
                totalErrors += project.getValue().size();
            }
            System.out.printf("Total Errors: %d\n", totalErrors);

            for (Map.Entry<String, ArrayList<String>> logType : projectEntry.getValue().entrySet()) {
                Integer totalLogErrors = 0;
                totalLogErrors += logType.getValue().size();
                if (logType.getKey().equals("Critical")) {
                    System.out.printf("Critical: %d\n", totalLogErrors);
                } else {
                    System.out.printf("Warnings: %d\n", totalLogErrors);
                }
            }

            for (Map.Entry<String, ArrayList<String>> logTypeEntry : projectEntry.getValue().entrySet()) {
                System.out.printf("%s Messages:\n", logTypeEntry.getKey());
                if (logTypeEntry.getValue().size() == 0) {
                    System.out.printf("--->None\n");
                }

                logTypeEntry.getValue().stream().sorted((e1, e2) -> {
                    if (e1.length() != e2.length()) {
                        return Integer.compare(e1.length(), e2.length());
                    }
                    return e1.compareTo(e2);
                }).forEach(e1 -> {
                    System.out.println("--->" + e1);
                });
            }

            currentProjecCount++;
            if (currentProjecCount != sortedProjects.size()) {
                System.out.println();
            }
        }
    }
}
