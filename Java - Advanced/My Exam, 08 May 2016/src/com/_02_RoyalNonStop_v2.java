package com;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class _02_RoyalNonStop_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixDims = scanner.nextLine().split(" ");
        int shopRows = Integer.parseInt(matrixDims[0]);
        int shopColumns = Integer.parseInt(matrixDims[1]);

        String[] prices = scanner.nextLine().split(" ");
        BigDecimal lukankaPrice = new BigDecimal(prices[0]);
        BigDecimal rakijaPrice = new BigDecimal(prices[1]);

        BigDecimal moneyEarned = BigDecimal.ZERO;
        int clientsCount = 0;

        String input = scanner.nextLine();
        while (!input.equals("Royal Close")){
            String[] targetCell = input.split(" ");
            int row = Integer.parseInt(targetCell[0]);
            int col = Integer.parseInt(targetCell[1]);

            BigDecimal currentClientPayment = BigDecimal.ZERO;
            if (row < col){
                for (int currentRow = row; currentRow >=0 ; currentRow--) {
                    if (currentRow % 2 == 0){
                        currentClientPayment = currentClientPayment.add(lukankaPrice.multiply(BigDecimal.valueOf((currentRow + 1)*(col + 1))));
                    } else {
                        currentClientPayment = currentClientPayment.add(rakijaPrice.multiply(BigDecimal.valueOf((currentRow + 1)*(col + 1))));
                    }
                }

                for (int currentCol = col - 1; currentCol >= 1; currentCol--) {
                    currentClientPayment = currentClientPayment.add(lukankaPrice.multiply(BigDecimal.valueOf(currentCol + 1)));
                }
            } else {
                for (int currentCol = col; currentCol >= 0 ; currentCol--) {
                    if (row % 2 == 0){
                        currentClientPayment = currentClientPayment.add(lukankaPrice.multiply(BigDecimal.valueOf((currentCol + 1)*(row + 1))));
                    } else {
                        currentClientPayment = currentClientPayment.add(rakijaPrice.multiply(BigDecimal.valueOf((currentCol + 1)*(row + 1))));
                    }
                }

                for (int currentRow = row - 1; currentRow >= 1; currentRow--) {
                    if (currentRow % 2 == 0){
                        currentClientPayment = currentClientPayment.add(lukankaPrice.multiply(BigDecimal.valueOf((currentRow + 1))));
                    } else {
                        currentClientPayment = currentClientPayment.add(rakijaPrice.multiply(BigDecimal.valueOf((currentRow + 1))));
                    }
                }
            }

            moneyEarned = moneyEarned.add(currentClientPayment);
            clientsCount++;
            input = scanner.nextLine();
        }

        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(moneyEarned));
        System.out.println(clientsCount);
    }
}
