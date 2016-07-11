package homeworks._08_ShapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TriangularPrism{
    private double baseSide;
    private double heightToBase;
    private double length;

    public TriangularPrism(double baseSide, double heightToBase, double length) {
        this.baseSide = baseSide;
        this.heightToBase = heightToBase;
        this.length = length;
    }

    public double getBaseSide() {
        return baseSide;
    }

    public double getHeightToBase() {
        return heightToBase;
    }

    public double getLength() {
        return length;
    }
}

class Cube{
    private double sideLength;

    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }
}

class Cylinder{
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
}

class VolumeCalculator{
    public static double calculateVolumeOfTriangularPrism(TriangularPrism triangularPrism){
        return (triangularPrism.getBaseSide() * triangularPrism.getLength() * triangularPrism.getHeightToBase()) / 2.0;
    }

    public static double calculateVolumeOfCube(Cube cube){
        return cube.getSideLength() * cube.getSideLength() * cube.getSideLength();
    }

    public static double calculateVolumeOfCylinder(Cylinder cylinder){
        return Math.PI * cylinder.getRadius() * cylinder.getRadius() * cylinder.getHeight();
    }
}

public class Pr08ShapesVolume {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String input = reader.readLine();
            if (input.equals("End")){
                break;
            }

            String[] figureInfo = input.split("\\s+");

            String figureType = figureInfo[0];
            switch (figureType){
                case "TrianglePrism":
                    double baseSide = Double.valueOf(figureInfo[1]);
                    double heightToBase = Double.valueOf(figureInfo[2]);
                    double length = Double.valueOf(figureInfo[3]);
                    TriangularPrism triangularPrism = new TriangularPrism(baseSide, heightToBase, length);
                    System.out.println(String.format("%.3f", VolumeCalculator.calculateVolumeOfTriangularPrism(triangularPrism)));
                    break;
                case "Cube":
                    double sideLength = Double.valueOf(figureInfo[1]);
                    Cube cube = new Cube(sideLength);
                    System.out.println(String.format("%.3f", VolumeCalculator.calculateVolumeOfCube(cube)));
                    break;
                case "Cylinder":
                    double radius = Double.valueOf(figureInfo[1]);
                    double height = Double.valueOf(figureInfo[2]);
                    Cylinder cylinder = new Cylinder(radius, height);
                    System.out.println(String.format("%.3f", VolumeCalculator.calculateVolumeOfCylinder(cylinder)));
                    break;
            }
        }
    }
}
