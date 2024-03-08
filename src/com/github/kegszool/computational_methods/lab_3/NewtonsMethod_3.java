package com.github.kegszool.computational_methods.lab_3;

public class NewtonsMethod_3 {

    private static final double ACCURACY = 0.0001f;
    private static final double X_0 = 3.0f;
    private static final double Y_0 = 3.0f;

    private static double determinateA, determinateB, determinateI;
    private static double newX, newY, currentX, currentY;

    public static void getSolution(){

        boolean isEnd;

        currentX = X_0;
        currentY = Y_0;

        do{
            calculateDeterminateA(currentX, currentY);
            calculateDeterminateB(currentX, currentY);
            calculateDeterminateI(currentX, currentY);

            newX = getNewX(currentX);
            newY = getNewY(currentY);

            isEnd = isCompletion(newX, currentX) && isCompletion(newY, newX);

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
        return Math.abs(nextElement - currentElement) <= ACCURACY;
    }

    private static void check(double x, double y){

        double firstResult = 3 * Math.pow(x, 2) * y + Math.pow(y, 2) - 1;
        double secondResult = Math.pow(x, 4) + Math.pow(x, 3) * y - 1;

        System.out.printf("3 * {0}^2 * {1} + {1} ^ 2 - 1 = {2}", x, y, firstResult);
        System.out.printf("{0}^4 + {0}^3 * {1} - 1 = {2}", x, y, secondResult);
    }
}