package homeworks._04_BeerCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BeerCounter{
    private static int beerInStock = 0;
    private static int beersDrankCount = 0;

    public static int getBeerInStock() {
        return beerInStock;
    }

    public static int getBeersDrankCount() {
        return beersDrankCount;
    }

    public static void BuyBeer(int bottlesCount){
        beerInStock += bottlesCount;
    }

    public static void DrinkBeer(int bottlesCount){
        beersDrankCount += bottlesCount;
        beerInStock -= bottlesCount;
    }
}

public class Pr04BeerCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String input = reader.readLine();
            if (input.equals("End")){
                break;
            }

            int[] beers = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            BeerCounter.BuyBeer(beers[0]);
            BeerCounter.DrinkBeer(beers[1]);
        }

        System.out.println(String.format("%d %d", BeerCounter.getBeerInStock(), BeerCounter.getBeersDrankCount()));
    }
}
