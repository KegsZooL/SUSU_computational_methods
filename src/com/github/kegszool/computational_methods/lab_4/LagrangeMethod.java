package com.github.kegszool.computational_methods.lab_4;

public class LagrangeMethod {

    public static void check(double x){

        double result = -14.2065822 * Math.pow(x, 2) +
                28.698273712 * x - 8.6031578032;

        System.out.printf("L(%f) = -14.2065822 * %f" +
                " + 28.698273712 * %f - 8.6031578032 = %f\n\n", x, x, x, result);
    }
}