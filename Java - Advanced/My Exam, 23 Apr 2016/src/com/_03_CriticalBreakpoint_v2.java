package com;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _03_CriticalBreakpoint_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> points = new ArrayList<>();
        while (!input.equals("Break it.")){
            points.add(input);

            input = scanner.nextLine();
        }

        List<String[]> printedList = new ArrayList<>();
        String[] splitInput = points.get(0).split(" ");
        printedList.add(splitInput);
        int x1 = Integer.parseInt(splitInput[0]);
        int y1 = Integer.parseInt(splitInput[1]);
        int x2 = Integer.parseInt(splitInput[2]);
        int y2 = Integer.parseInt(splitInput[3]);
        long criticalRatio = Math.abs((x2 + y2) - (x1 + y1));
        long curretntCriticalRatio = 0;
        for (int i = 1; i < points.size(); i++) {
            splitInput = points.get(i).split(" ");
            printedList.add(splitInput);
            x1 = Integer.parseInt(splitInput[0]);
            y1 = Integer.parseInt(splitInput[1]);
            x2 = Integer.parseInt(splitInput[2]);
            y2 = Integer.parseInt(splitInput[3]);

            curretntCriticalRatio = Math.abs(((long)x2 + (long)y2) - ((long)x1 + (long)y1));

            if (criticalRatio == 0){
                criticalRatio = curretntCriticalRatio;
            }

            if (curretntCriticalRatio != 0 && curretntCriticalRatio != criticalRatio){
                System.out.println("Critical breakpoint does not exist.");

                return;
            }
        }

        for (int i = 0; i < printedList.size(); i++) {
            System.out.println("Line: " + Arrays.toString(printedList.get(i)));
        }

        BigInteger criticalBreakpoint = (BigInteger.valueOf(criticalRatio).pow(points.size())).mod(BigInteger.valueOf(points.size()));
        System.out.println("Critical Breakpoint: " + criticalBreakpoint);
    }
}
