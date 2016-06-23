package com;

import java.util.*;

public class _02_Crossfire_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        List<List<String>> matrix = new ArrayList<>();
        int value = 1;
        for (int row = 0; row < rows; row++) {
            List<String> listRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                listRow.add(value + "");
                value++;
            }
            matrix.add(listRow);
        }

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] splitInput = input.split(" ");

            long targetRow = Integer.parseInt(splitInput[0]);
            long targetCol = Integer.parseInt(splitInput[1]);
            long radius = Integer.parseInt(splitInput[2]);

            if ((0 <= targetRow && targetRow < rows) || (0 <= targetCol && targetCol < cols)){
                for (int row = matrix.size() - 1; row >= 0; row--) {
                    if (row == targetRow){
                        for (int col = matrix.get(row).size() - 1; col >= 0; col--) {
                            if (targetCol - radius <= col && col <= targetCol + radius){
                                matrix.get(row).remove(col);
                            }
                        }
                    } else {
                        for (int i = 0; i < matrix.get(row).size(); i++) {
                            if (i == targetCol && (targetRow - radius <= row) && (targetRow + radius >= row)){
                                matrix.get(row).remove(i);
                            }
                        }
                    }
                }

                for (int i = matrix.size() - 1; i >= 0 ; i--) {
                    if (matrix.get(i).size() == 0){
                        matrix.remove(i);
                    }
                }
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(String.join(" ", matrix.get(i)));
        }
    }
}
