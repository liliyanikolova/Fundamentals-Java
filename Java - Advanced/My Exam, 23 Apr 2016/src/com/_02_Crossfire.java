package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02_Crossfire {
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
        while (!input.equals("Nuke it from orbit")){
            String[] splitInput = input.split(" ");

            int targetRow = Integer.parseInt(splitInput[0]);
            int targetCol = Integer.parseInt(splitInput[1]);
            int radius = Integer.parseInt(splitInput[2]);

            long topRow = targetRow - radius;
            if (topRow < 0 ){
                topRow = 0;
            }

            if (topRow > matrix.size() - 1){
                topRow = matrix.size() - 1;
            }

            long bottomRow = targetRow + radius;
            if (bottomRow > matrix.size() - 1){
                bottomRow = matrix.size() - 1;
            }

            if (bottomRow < 0){
                bottomRow = 0;
            }

            long leftCol = targetCol - radius;
            if (leftCol < 0 ){
                leftCol = 0;
            }

            if (leftCol > cols - 1){
                leftCol = cols - 1;
            }

            long rightCol = targetCol + radius;
            if (rightCol > cols - 1){
                rightCol = cols - 1;
            }

            if (rightCol < 0){
                rightCol = 0;
            }

            for (int i = (int)bottomRow; i >= topRow; i--) {
                if (i == targetRow){
                    for (int j = (int)rightCol ; j >= leftCol; j--) {
                        if (j < matrix.get(i).size()){
                            matrix.get(i).remove(j);
                        }
                    }

                    continue;
                }

                if (matrix.get(i).size() - 1 >= targetCol){
                    matrix.get(i).remove(targetCol);
                }
            }

            for (int i = matrix.size() - 1; i >= 0 ; i--) {
                if (matrix.get(i).size() == 0){
                    matrix.remove(i);
                }
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(String.join(" ", matrix.get(i)));
        }
    }
}
