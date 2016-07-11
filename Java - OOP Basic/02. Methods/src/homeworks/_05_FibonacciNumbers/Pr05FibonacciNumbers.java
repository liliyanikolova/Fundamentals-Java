package homeworks._05_FibonacciNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Fibonacci{
    public ArrayList<Long> getNumbersInRange(int startPosition, int endPosition) {
        ArrayList<Long> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(0l);
        fibonacciNumbers.add(1l);

        for (int i = 2; i < endPosition; i++) {
            long first = fibonacciNumbers.get(i - 2);
            long second = fibonacciNumbers.get(i -1);
            long num = first + second;
            fibonacciNumbers.add(num);
        }

        ArrayList<Long> result = new ArrayList<>();
        for (int i = startPosition; i < endPosition; i++) {
            result.add(fibonacciNumbers.get(i));
        }

        return result;
    }
}

public class Pr05FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstPosition = Integer.parseInt(reader.readLine());
        int secondPosition = Integer.parseInt(reader.readLine());
        Fibonacci fibonacciNumbers = new Fibonacci();
        ArrayList<Long> numbers = fibonacciNumbers.getNumbersInRange(firstPosition, secondPosition);
        for (int i = 0; i < numbers.size() - 1; i++) {
            System.out.print(numbers.get(i) + ", ");
        }

        System.out.println(numbers.get(numbers.size() - 1));
    }
}
