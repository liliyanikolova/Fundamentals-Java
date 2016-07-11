package homeworks._03_TemperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TemperatureConverter{
    public static double convertFromCelsiusToFahrenheit(int temperature){
        return (double) temperature * 9 / 5 + 32;
    }

    public static double convertFromFahrenheitToCelsius(int temperature){
        return (double) (temperature - 32) * 5 / 9;
    }
}

public class Pr03TemperatureConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String input = reader.readLine();
            if (input.equals("End")){
                break;
            }

            String[] splitInput = input.split("\\s+");
            int temperature = Integer.valueOf(splitInput[0]);
            double result = 0;
            switch (splitInput[1]){
                case "Celsius":
                    result = TemperatureConverter.convertFromCelsiusToFahrenheit(temperature);
                    System.out.println(String.format("%.2f Fahrenheit", result));
                    break;
                case "Fahrenheit":
                    result = TemperatureConverter.convertFromFahrenheitToCelsius(temperature);
                    System.out.println(String.format("%.2f Celsius", result));
                    break;
            }
        }
    }
}
