package com;

import java.math.BigDecimal;
import java.util.Scanner;

public class _02_RoyalNonStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixDims = scanner.nextLine().split(" ");
        int shopRows = Integer.parseInt(matrixDims[0]);
        int shopColumns = Integer.parseInt(matrixDims[1]);

        String[] prices = scanner.nextLine().split(" ");
        BigDecimal lukankaPrice = BigDecimal.valueOf(Double.parseDouble(prices[0]));
        BigDecimal rakijaPrice = BigDecimal.valueOf(Double.parseDouble(prices[1]));

        BigDecimal moneyEarned = BigDecimal.ZERO;
        int clientsCount = 0;

        String input = scanner.nextLine();
        while (!input.equals("Royal Close")){
            String[] targetCell = input.split(" ");
            int row = Integer.parseInt(targetCell[0]);
            int col = Integer.parseInt(targetCell[1]);

            BigDecimal currentClientPayment = BigDecimal.ZERO;

            if (row < col){
                for (int i = row; i >= 0 ; i--) {
                    if (i % 2 == 0){
                        currentClientPayment = currentClientPayment.add(lukankaPrice);
                    } else {
                        currentClientPayment = currentClientPayment.add(rakijaPrice);
                    }
                }

                currentClientPayment = currentClientPayment.add(lukankaPrice.multiply(BigDecimal.valueOf(col - 1)));
            } else {
                for (int i = col; i >= 0; i++) {
                    if (row % 2 == 0){
                        currentClientPayment = currentClientPayment.add(lukankaPrice.multiply(BigDecimal.valueOf((row + 1)*(col + 1))).multiply(BigDecimal.valueOf(col + 1)));
//                    currentClientPayment.add(lukankaPrice.multiply(BigDecimal.valueOf(col)));
                    } else {
                        currentClientPayment = currentClientPayment.add(rakijaPrice.multiply(BigDecimal.valueOf((row + 1)*(col + 1))).multiply(BigDecimal.valueOf(col)));
//                    currentClientPayment.add(rakijaPrice.multiply(BigDecimal.valueOf(col)));
                    }
                }

                if (row >= 1){
                    for (int i = row - 1; i >= 1 ; i--) {
                        if (i % 2 == 0){
                            currentClientPayment = currentClientPayment.add(lukankaPrice.multiply(BigDecimal.valueOf((row + 1)*(col + 1))));
                        } else {
                            currentClientPayment = currentClientPayment.add(rakijaPrice.multiply(BigDecimal.valueOf((row + 1)*(col + 1))));
                        }
                    }
                }
            }

            moneyEarned = moneyEarned.add(currentClientPayment);
            clientsCount++;
            input = scanner.nextLine();
        }

        System.out.println(moneyEarned);
        System.out.println(clientsCount);
    }
}
