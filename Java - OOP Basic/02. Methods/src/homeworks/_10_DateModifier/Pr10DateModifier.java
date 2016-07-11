package homeworks._10_DateModifier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

class DateModifier{
    public long geDifferenceBetweenTwoDates(String first, String second) throws ParseException {
        String[] startParams = first.split("\\s+");
        String[] endParams = second.split("\\s+");

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        int firstDateYear = Integer.parseInt(startParams[0]);
        int secondDateYear = Integer.parseInt(endParams[0]);
        int firstDateMonth = Integer.parseInt(startParams[1]);
        int secondDateMonth = Integer.parseInt(endParams[1]);
        int firstDateDay = Integer.parseInt(startParams[2]);
        int secondDateDay = Integer.parseInt(endParams[2]);

        start.set(firstDateYear, firstDateMonth, firstDateDay);
        end.set(secondDateYear, secondDateMonth, secondDateDay);

        Date firstDate = start.getTime();
        Date secondDate = end.getTime();

        long timeDifference = Math.abs(secondDate.getTime() - firstDate.getTime());
        long result = timeDifference / (24 * 60 * 60 * 1000);

        return result;
    }
}

public class Pr10DateModifier {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstDate = reader.readLine();
        String secondDate = reader.readLine();

        DateModifier dateModifier = new DateModifier();
        long result = dateModifier.geDifferenceBetweenTwoDates(firstDate, secondDate);
        System.out.println(result);
    }
}
