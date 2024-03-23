package com.github.kegszool.computational_methods.lab_5;

import java.util.Arrays;
import java.util.List;

public class NumericalIntegration {

    private static final List<Double> range = Arrays.asList(
            -1.0, -0.8, -0.6, -0.4, -0.2, 0.0, 0.2, 0.4, 0.6, 0.8);

    private static final double h = 0.2;

    public static void calculateByRectangle(){

        double result = h * range.stream()
                            .mapToDouble(num -> Math.abs(num))
                            .sum();

        System.out.printf("[-1, 1] ∫|x|dx = %f * (", h);

        for (int i = 0; i < range.size(); i++) {

            double currentNumber = range.get(i);

            if(i == range.size() - 1){
                System.out.printf("|%f|) = %f\n", currentNumber, result);
            }else{
                System.out.printf("|%f| + ", currentNumber);
            }
        }
    }
}
