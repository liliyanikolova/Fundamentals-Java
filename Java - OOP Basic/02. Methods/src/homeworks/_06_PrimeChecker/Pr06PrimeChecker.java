package homeworks._06_PrimeChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Number{
    private int value;
    private boolean prime;

    public Number(int value, boolean isPrime) {
        this.value = value;
        this.prime = isPrime;
    }

    public int getValue() {
        return value;
    }

    public boolean getPrime() {
        return prime;
    }

    public Number getNexPrimeNumber(){
        Number nextPrimeNumber =  new Number(0, true);

        for (int p = this.getValue() + 1; p < 2 * this.getValue() + 1; p++) {
            boolean isCurrentNumberPrime = true;
            for (int i = 2; i < p; i++) {
                if (p % i == 0){
                    isCurrentNumberPrime = false;
                    break;
                }
            }

            if (isCurrentNumberPrime){
                nextPrimeNumber = new Number(p, true);
                break;
            } else {
                continue;
            }
        }

        return nextPrimeNumber;
    }

    public boolean isPrime(){
        boolean result = true;

        for (int i = 2; i < this.getValue(); i++) {
            if (this.getValue() % i == 0){
                result = false;
                break;
            }
        }

        return result;
    }
}

public class Pr06PrimeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        Number currentNumber = new Number(number, true);
        Number nextPrimeNumber = currentNumber.getNexPrimeNumber();

        System.out.println(nextPrimeNumber.getValue() + ", " + currentNumber.isPrime());
    }
}
