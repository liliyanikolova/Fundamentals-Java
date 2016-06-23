package com;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _04_RoyalAccounting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> allEmployees = new ArrayList<>();
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<BigDecimal>>> teamsData = new LinkedHashMap<>();
        while (!input.equals("Pishi kuf i da si hodim")){
//            Pattern pattern = Pattern.compile("^([a-zA-Z]+);(\d+);((\d+\.?\d+)|(\d+));([a-zA-Z]+)$");
            Pattern pattern = Pattern.compile("^([a-zA-Z]+);(-?\\d+);(-?\\d+\\.?\\d*);([a-zA-Z]+)$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String[] splitInput = input.split(";");
                String teamName = splitInput[3];
                String employeeName = splitInput[0];
                BigDecimal workHoursPerDay = new BigDecimal(splitInput[1]);
                BigDecimal dailyPayment = new BigDecimal(splitInput[2]);

                if (!allEmployees.contains(employeeName)){
                    allEmployees.add(employeeName);

                    if (!teamsData.containsKey(teamName)){
                        teamsData.put(teamName, new LinkedHashMap<>());
                    }

                    ArrayList<BigDecimal> emplHoursPayments = new ArrayList<>();
                    emplHoursPayments.add(workHoursPerDay);
                    emplHoursPayments.add(dailyPayment);
                    teamsData.get(teamName).put(employeeName, emplHoursPayments);
                }
            }

            input = scanner.nextLine();
        }

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<BigDecimal>>> sortedTeamsData = teamsData.entrySet()
                .stream()
                .sorted((firstTeam, secondTeam) -> {
                    BigDecimal firstTeamPayments = BigDecimal.ZERO;
                    BigDecimal secondTeamPayments = BigDecimal.ZERO;
                    for (Map.Entry<String,ArrayList<BigDecimal>> employeeEntry : firstTeam.getValue().entrySet()) {
                        firstTeamPayments = firstTeamPayments.add((employeeEntry.getValue().get(0).multiply(employeeEntry.getValue().get(1))
                                .divide(BigDecimal.valueOf((long)24), 9, BigDecimal.ROUND_HALF_UP)
                                .multiply(BigDecimal.valueOf(30))));
                    }

                    for (Map.Entry<String,ArrayList<BigDecimal>> employeeEntry : secondTeam.getValue().entrySet()) {
                        secondTeamPayments = secondTeamPayments.add((employeeEntry.getValue().get(0).multiply(employeeEntry.getValue().get(1))
                                .divide(BigDecimal.valueOf((long)24), 9, BigDecimal.ROUND_HALF_UP)
                                .multiply(BigDecimal.valueOf(30))));
                    }

                    return secondTeamPayments.compareTo(firstTeamPayments);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y)-> {throw new AssertionError();},
                        LinkedHashMap::new
                ));
        for (Map.Entry<String,LinkedHashMap<String,ArrayList<BigDecimal>>> teamEntry : sortedTeamsData.entrySet()) {
            System.out.println("Team - " + teamEntry.getKey());
            LinkedHashMap<String, ArrayList<BigDecimal>> sortedEmployee = teamEntry.getValue().entrySet()
                    .stream()
                    .sorted((firstEmployee, secondEmployee) -> {
                        int result = secondEmployee.getValue().get(0).compareTo(firstEmployee.getValue().get(0));
                        if (result == 0){
                            BigDecimal firstEmployeeDailyIncome = firstEmployee.getValue().get(0)
                                    .multiply(firstEmployee.getValue().get(1))
                                    .divide(BigDecimal.valueOf((long)24), 9, BigDecimal.ROUND_HALF_UP);
                            BigDecimal secondEmployeeDailyIncome = secondEmployee.getValue().get(0)
                                    .multiply(secondEmployee.getValue().get(1))
                                    .divide(BigDecimal.valueOf((long)24), 9, BigDecimal.ROUND_HALF_UP);

                            result = secondEmployeeDailyIncome.compareTo(firstEmployeeDailyIncome);
                        }

                        return result;
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x,y)-> {throw new AssertionError();},
                            LinkedHashMap::new
                    ));
            for (Map.Entry<String,ArrayList<BigDecimal>> employeeEntry : sortedEmployee.entrySet()) {
                BigDecimal dailyIncome =  employeeEntry.getValue().get(0)
                        .multiply(employeeEntry.getValue().get(1))
                        .divide(BigDecimal.valueOf((long)24), 6, BigDecimal.ROUND_HALF_UP);
                System.out.println("$$$" + employeeEntry.getKey() + " - " + employeeEntry.getValue().get(0) + " - " + dailyIncome);
            }
        }
    }
}
