package homeworks._03_LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Number{
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public String displayLastDigitWithEnglishName(){
        int lastDigit = this.number % 10;
        String result = null;
        switch (lastDigit){
            case 0:
                result = "zero";
                break;
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
        }

        return result;
    }
}

public class Pr03LastDigitName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Number number = new Number(Integer.parseInt(reader.readLine()));

        System.out.println(number.displayLastDigitWithEnglishName());
    }
}
