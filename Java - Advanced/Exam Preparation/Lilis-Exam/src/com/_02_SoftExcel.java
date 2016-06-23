package com;

import java.util.Scanner;

public class _02_SoftExcel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixHight = scanner.nextInt();
        int matrixWidth = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[matrixHight][matrixWidth];
        for (int i = 0; i < matrixHight; i++) {
            matrix[i] = scanner.nextLine().split(",");
        }

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] command = input.split("\\s+");
            int index = Integer.parseInt(command[1]);
            int sum = 0;
            if (command[0].equals("row")){
                for (int i = 0; i < matrixWidth; i++) {
                    if (matrix[index][i].matches("[+-]?\\d*(\\.\\d+)?")){
                        sum += Integer.parseInt(matrix[index][i]);
                    } else {
                        sum += matrix[index][i].length();
                    }
                }

                System.out.println(sum);
                for (int i = 0; i < matrixWidth; i++) {
                    if (matrix[index][i].matches("[+-]?\\d*(\\.\\d+)?")){
                        matrix[index][i] = Integer.toString(sum - Integer.parseInt(matrix[index][i]));
                    } else {
                        matrix[index][i] = Integer.toString(sum - matrix[index][i].length());
                    }
                }
            } else if(command[0].equals("column")){
                for (int i = 0; i < matrixHight; i++) {
                    if (matrix[i][index].matches("[+-]?\\d*(\\.\\d+)?")){
                        sum += Integer.parseInt(matrix[i][index]);
                    } else {
                        sum += matrix[i][index].length();
                    }
                }

                System.out.println(sum);
                for (int i = 0; i < matrixHight; i++) {
                    if (matrix[i][index].matches("[+-]?\\d*(\\.\\d+)?")){
                        matrix[i][index] = Integer.toString(sum - Integer.parseInt(matrix[i][index]));
                    } else {
                        matrix[i][index] = Integer.toString(sum - matrix[i][index].length());
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < matrixHight; i++) {
            System.out.println(String.join(" ", matrix[i]));
        }
    }
}
