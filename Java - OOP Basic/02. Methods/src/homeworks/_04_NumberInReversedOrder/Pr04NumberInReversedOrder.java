package homeworks._04_NumberInReversedOrder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DecimalNumber{
    private String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public void printsAllDigitsInReverseOrder(){
        for (int i = 0; i < this.number.length(); i++) {
            Character digit = this.number.charAt(this.number.length() - i - 1);
            System.out.print(digit);
        }

        System.out.println();
    }
}

public class Pr04NumberInReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DecimalNumber number = new DecimalNumber(reader.readLine());
        number.printsAllDigitsInReverseOrder();
    }
}
