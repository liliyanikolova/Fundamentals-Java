package com;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _04_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> allEmployees = new ArrayList<>();
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<Double>>> teamsData = new LinkedHashMap<>();
        while (!input.equals("Pishi kuf i da si hodim")){
            Pattern pattern = Pattern.compile("^([a-zA-Z]+);(-?\\d+);(-?\\d+\\.?\\d*);([a-zA-Z]+)$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String[] splitInput = input.split(";");
                String teamName = splitInput[3];
                String employeeName = splitInput[0];
                double workHoursPerDay = Double.parseDouble(splitInput[1]);
                double dailyPayment = Double.parseDouble(splitInput[2]);

                if (!allEmployees.contains(employeeName)){
                    allEmployees.add(employeeName);

                    if (!teamsData.containsKey(teamName)){
                        teamsData.put(teamName, new LinkedHashMap<>());
                    }

                    ArrayList<Double> emplHoursPayments = new ArrayList<>();
                    emplHoursPayments.add(workHoursPerDay);
                    emplHoursPayments.add(dailyPayment);
                    teamsData.get(teamName).put(employeeName, emplHoursPayments);
                }
            }

            input = scanner.nextLine();
        }

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<Double>>> sortedTeamsData = teamsData.entrySet()
                .stream()
                .sorted((firstTeam, secondTeam) -> {
                    Double firstTeamPayments = 0d;
                    Double secondTeamPayments = 0d;
                    for (Map.Entry<String,ArrayList<Double>> employeeEntry : firstTeam.getValue().entrySet()) {
                        firstTeamPayments += ((employeeEntry.getValue().get(0)*employeeEntry.getValue().get(1))/24)*30;
                    }

                    for (Map.Entry<String,ArrayList<Double>> employeeEntry : secondTeam.getValue().entrySet()) {
                        secondTeamPayments += ((employeeEntry.getValue().get(0)*employeeEntry.getValue().get(1))/24)*30;
                    }

                    return secondTeamPayments.compareTo(firstTeamPayments);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y)-> {throw new AssertionError();},
                        LinkedHashMap::new
                ));
        for (Map.Entry<String,LinkedHashMap<String,ArrayList<Double>>> teamEntry : sortedTeamsData.entrySet()) {
            System.out.println("Team - " + teamEntry.getKey());
            LinkedHashMap<String, ArrayList<Double>> sortedEmployee = teamEntry.getValue().entrySet()
                    .stream()
                    .sorted((firstEmployee, secondEmployee) -> {
                        int result = secondEmployee.getValue().get(0).compareTo(firstEmployee.getValue().get(0));
                        if (result == 0){
                            Double firstEmployeeDailyIncome = (firstEmployee.getValue().get(0)*firstEmployee.getValue().get(1))/24;
                            Double secondEmployeeDailyIncome = (secondEmployee.getValue().get(0)*secondEmployee.getValue().get(1))/24;

                            result = secondEmployeeDailyIncome.compareTo(firstEmployeeDailyIncome);

                            if (result == 0){
                                result = firstEmployee.getKey().compareTo(secondEmployee.getKey());
                            }
                        }

                        return result;
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x,y)-> {throw new AssertionError();},
                            LinkedHashMap::new
                    ));
            for (Map.Entry<String,ArrayList<Double>> employeeEntry : sortedEmployee.entrySet()) {
                Double dailyIncome = (employeeEntry.getValue().get(0)*employeeEntry.getValue().get(1))/24;
                System.out.printf("$$$%s - %s - %.6f\n", employeeEntry.getKey(), employeeEntry.getValue().get(0).intValue(), dailyIncome);
            }
        }
    }
}
