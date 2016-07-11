package homeworks._07_BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MathUtil{
    public static double sum(double firstNumber, double secondNumber){
        return firstNumber + secondNumber;
    }

    public static double subtract(double firstNumber, double secondNumber){
        return firstNumber - secondNumber;
    }

    public static double multiply(double firstNumber, double secondNumber){
        return firstNumber * secondNumber;
    }

    public static double divide(double dividend, double divisor){
        return dividend / divisor;
    }

    public static double percentage(double number, double percentOfNumber){
        return number * (percentOfNumber / 100);
    }
}

public class Pr07BasicMath {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String input = reader.readLine();
            if (input.equals("End")){
                break;
            }

            String[] command = input.split("\\s+");

            String operation = command[0];
            double firstNumber = Double.valueOf(command[1]);
            double secondNumber = Double.valueOf(command[2]);
            switch (operation){
                case "Sum":
                    System.out.println(String.format("%.2f", MathUtil.sum(firstNumber, secondNumber)));
                    break;
                case "Subtract":
                    System.out.println(String.format("%.2f", MathUtil.subtract(firstNumber, secondNumber)));
                    break;
                case "Multiply":
                    System.out.println(String.format("%.2f", MathUtil.multiply(firstNumber, secondNumber)));
                    break;
                case "Divide":
                    System.out.println(String.format("%.2f", MathUtil.divide(firstNumber, secondNumber)));
                    break;
                case "Percentage":
                    System.out.println(String.format("%.2f", MathUtil.percentage(firstNumber, secondNumber)));
                    break;
            }
        }
    }
}
