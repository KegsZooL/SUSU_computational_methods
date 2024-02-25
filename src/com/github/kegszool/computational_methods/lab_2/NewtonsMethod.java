package com.github.kegszool.computational_methods.lab_2;

public class NewtonsMethod {

    private static final double ACCURACY = 0.0001; // Точность
    private static final double INITIAL_APPROXIMATE = 1.35; //Начальное приближенное

    private static double difference;

    public static double getSolution(NewtonsOperation type) {

        double currentX = INITIAL_APPROXIMATE, previous;
        int iteration = 0;

        if (type == NewtonsOperation.ORDINARY){
            System.out.println("\n============== Обычный метод Ньютона ===================");
        }else{
            System.out.println("\n=========== Модифицированный метод Ньютона ===========");
        }

        System.out.printf("[%-2d] x = %.5f\n", iteration++, currentX);

        do {
            previous = currentX;
            currentX = getNextX(currentX, type);

            if(isCompletion(currentX, previous)){
                break;
            }

            System.out.printf("[%-2d] x = %.5f\t |%.6f - %.6f| = %.6f\n",
                    iteration++, currentX, currentX, previous, difference);

        } while (true);

        System.out.printf("\nКритерий завершения:\n[%-2d] x = %.6f\t |%.6f - %.6f| = %.6f <= %.4f\n",
                ++iteration, currentX, currentX, previous, difference, ACCURACY);

        System.out.printf("\nПроверка: %f ^ 4 * exp(4 * %f) - 444 ≈ %f\n", previous, previous, getValueOfTheEquation(previous));

        return currentX;
    }

    // Основная формула
    private static double getNextX(double currentX, NewtonsOperation type) {

        if(type == NewtonsOperation.ORDINARY){
            return currentX - getValueOfTheEquation(currentX) / getDerivateOfGivenFunction(currentX);
        }
        return currentX - getValueOfTheEquation(currentX) / getDerivateOfGivenFunction(INITIAL_APPROXIMATE);
    }

    //Производная от функции x^4 * exp(4x)
    private static double getDerivateOfGivenFunction(double value)
    {
        return (4 * Math.pow(value, 3) * Math.exp(4 * value)) + (4 * Math.pow(value, 4) * Math.exp(4 * value));
    }

    //Производная второго порядка
    private static double getSecondDerivateOfGievenFunction(double value){
        return (16 * Math.pow(value, 4) + 32 * Math.pow(value, 3) + 12 * Math.pow(value, 2)) * Math.exp(4 * value);
    }

    //Подсчет уравнения
    private static double getValueOfTheEquation(double currentX) {
        return Math.pow(currentX, 4) * Math.exp(4 * currentX) - 444;
    }

    //Критерий завершения
    private static boolean isCompletion(double next, double current) {

        difference = Math.abs(next - current);
        return difference <= ACCURACY;
    }

    private static void checkSolution(double x)
    {
        System.out.println(getValueOfTheEquation(x));
    }

    //Проверка сходимости метода
    public static boolean checkConvergenceMethod()
    {
        double b = Math.abs(1 / getDerivateOfGivenFunction(INITIAL_APPROXIMATE));
        double n = Math.abs(getValueOfTheEquation(INITIAL_APPROXIMATE) / getDerivateOfGivenFunction(INITIAL_APPROXIMATE));


        double k = getSecondDerivateOfGievenFunction(INITIAL_APPROXIMATE);

        double h = b * n * k;

        System.out.printf("\nПроверка сходимости метода:\nh = %f * %f * %f\n", b, n, k);
        System.out.printf("h = %f <= 0.5\n", h);

        return h <= 0.5;
    }
}