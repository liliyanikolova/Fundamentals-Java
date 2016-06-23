package com;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _03_CriticalBreakpoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> points = new ArrayList<>();
        while (!input.equals("Break it.")){
            points.add(input);

            input = scanner.nextLine();
        }

        List<String[]> printedList = new ArrayList<>();
        List<Long> criticalRatios = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            String[] splitInput = points.get(i).split(" ");
            printedList.add(splitInput);
            long x1 = Integer.parseInt(splitInput[0]);
            long y1 = Integer.parseInt(splitInput[1]);
            long x2 = Integer.parseInt(splitInput[2]);
            long y2 = Integer.parseInt(splitInput[3]);

            long curretntCriticalRatio = Math.abs((x2 + y2) - (x1 + y1));
            criticalRatios.add(curretntCriticalRatio);
        }

        Long criticalRatio = 0l;
        for (int i = 0; i < criticalRatios.size(); i++) {
            if (criticalRatios.get(i) != 0){
                criticalRatio = criticalRatios.get(i);
                break;
            }
        }

        for (int i = 0; i < criticalRatios.size(); i++) {
            if (criticalRatios.get(i) != 0 && criticalRatios.get(i) != criticalRatio){
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
