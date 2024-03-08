package com.github.kegszool.computational_methods.lab_3;

import java.security.spec.RSAOtherPrimeInfo;

public class NewtonsMethod_3 {

    private static final double ACCURACY = 0.0001;
    private static final double X_0 = 0.01;
    private static final double Y_0 = 0.01;

    private static double determinateA, determinateB, determinateI;
    private static double newX, newY, currentX, currentY;
    private static double difference;

    public static void getSolution(){

        int count = 0;
        boolean isEnd;

        currentX = X_0;
        currentY = Y_0;

        do{
            calculateDeterminateA(currentX, currentY);
            calculateDeterminateB(currentX, currentY);
            calculateDeterminateI(currentX, currentY);

            if(determinateI == 0){
                break;
            }

            newX = getNewX(currentX);
            newY = getNewY(currentY);

            isEnd = isCompletion(newX, currentX) && isCompletion(newY, currentY);

            System.out.printf("[%d] |%f - %f| = %f\n", count, newX, currentX, difference);
            System.out.printf("[%d] |%f - %f| = %f\n\n", count++, newY, currentY, difference);

            currentX = newX;
            currentY = newY;
        }
        while (!isEnd);

        check(currentX, currentY);
    }

    private static double getNewX(double currentX){
        return currentX - determinateA / determinateI;
    }

    private static double getNewY(double currentY){
        return currentY - determinateB / determinateI;
    }

    private static void calculateDeterminateA(double x, double y){
        determinateA = 3 * Math.pow(x, 6) + 2 * Math.pow(x, 4) * y +
                Math.pow(x, 3) * Math.pow(y, 2) + Math.pow(x, 3) - 3 * Math.pow(x, 2) - 2 * y;
    }

    private static void calculateDeterminateB(double x, double y){
        determinateB = 6 * Math.pow(x, 5) * y + 6 * x * y + 4 * Math.pow(x, 3) * Math.pow(y, 2) -
                4 * Math.pow(x, 3) + 3 * Math.pow(x, 4) * Math.pow(y, 2) + 3 * Math.pow(x, 2) *
                Math.pow(y, 3) - 3 * Math.pow(x, 2) * y;
    }

    private static void calculateDeterminateI(double x, double y){
        determinateI = 12 * Math.pow(x, 5) + 8 * Math.pow(x, 3) * y +
                3 * Math.pow(x, 4) * y + 6 * Math.pow(x, 2) * Math.pow(y, 2);
    }

    private static boolean isCompletion(double nextElement, double currentElement){
        difference = Math.abs(nextElement - currentElement);
        return difference <= ACCURACY;
    }

    private static void check(double x, double y){

        double firstResult = 3 * Math.pow(x, 2) * y + Math.pow(y, 2) - 1;
        double secondResult = Math.pow(x, 4) + Math.pow(x, 3) * y - 1;

        System.out.printf("x = %-5f y = %-5f\n\n", x, y);
        System.out.printf("3 * %.4f^2 * %.4f + %.4f^2 - 1 ≈  %.11f\n", x, y, y, firstResult);
        System.out.printf("%.4f^4 + %.4f^3 * %.4f - 1 ≈  %.11f\n", x, x, y, secondResult);
    }
}