package homeworks._11_RectangleIntersection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Rectangle{
    private String id;
    private double width;
    private double height;
    private double topLeftX;
    private double topLeftY;
    private double downRightX;
    private double downRightY;

    public Rectangle(String id, double width, double height, double topLeftX, double topLeftY) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.downRightX = topLeftX + this.width;
        this.downRightY = topLeftY + this.height;
    }

    public boolean isIntersect(Rectangle rectangle){
        boolean result =  this.topLeftX <= rectangle.downRightX &&
                rectangle.topLeftX <= this.downRightX &&
                this.topLeftY <= rectangle.downRightY &&
                rectangle.topLeftY <= this.downRightY;

        return result;
    }
}

public class Pr11RectangleIntersection {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        double numberOfRectangles = Integer.parseInt(input[0]);
        double numberOfIntersectionChecks = Integer.parseInt(input[1]);

        Map<String, Rectangle> rectanglesById = new HashMap();
        for (int i = 0; i < numberOfRectangles; i++) {
            String[] rectangleParams = reader.readLine().split("\\s+");
            String id = rectangleParams[0];
            double width = Double.parseDouble(rectangleParams[1]);
            double height = Double.parseDouble(rectangleParams[2]);
            double topLeftX = Double.parseDouble(rectangleParams[3]);
            double topLeftY = Double.parseDouble(rectangleParams[4]);
            Rectangle rectangle = new Rectangle(id, width, height, topLeftX, topLeftY);
            rectanglesById.put(id, rectangle);
        }

        for (int i = 0; i < numberOfIntersectionChecks; i++) {
            String[] rectanglesForCheck = reader.readLine().split("\\s+");
            Rectangle firstRectangleId = rectanglesById.get(rectanglesForCheck[0]);
            Rectangle secondRectangleId = rectanglesById.get(rectanglesForCheck[1]);
            System.out.println(firstRectangleId.isIntersect(secondRectangleId));
        }
    }
}
