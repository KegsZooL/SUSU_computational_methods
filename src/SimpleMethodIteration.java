public class SimpleMethodIteration {

    private static final float ACCURACY = 0.001f;

    private static final float INITIAL_APPROXIMATE_X = 1.43478261f;
    private static final float INITIAL_APPROXIMATE_Y = 1.08333f;
    private static final float INITIAL_APPROXIMATE_Z = 1.76f;

    public static void main(String[] args) {

        int iterationNumber = 0;

        float x = INITIAL_APPROXIMATE_X;
        float y = INITIAL_APPROXIMATE_Y;
        float z = INITIAL_APPROXIMATE_Z;

        float newX, newY, newZ;

        do {
            newX = calculateX(y, z);
            newY = calculateY(x, z);
            newZ = calculateZ(x, y);

            System.out.println(String.format("[%d] X: %f Y: %f Z: %f", iterationNumber++, newX, newY, newZ));

            if (isCompletion(x, newX) && isCompletion(y, newY) && isCompletion(z, newZ)) {
                break;
            }

            x = newX;
            y = newY;
            z = newZ;

        } while (true);

        System.out.println("\nРешение: x = " + x + ", y = " + y + ", z = " + z);

        System.out.println("\nПроверка:");

        conductCheck(x, y, z);
    }

    private static float calculateX(float y, float z) {
        return -0.47826087f * y - 0.1f * z + INITIAL_APPROXIMATE_X;
    }

    private static float calculateY(float x, float z) {
        return -0.125f * x - 0.8333f * z + INITIAL_APPROXIMATE_Y;
    }

    private static float calculateZ(float x, float y) {
        return -0.08f * x - 0.84f * y + INITIAL_APPROXIMATE_Z;
    }

    private static boolean isCompletion(float current, float next) {
        return Math.abs(next - current) <= ACCURACY;
    }

    private static void conductCheck(float x, float y, float z){

        float [][] matrix = {{2.3f * x + 1.f * y + 0.23f * z, 3.3f},
                             {0.3f * x + 2.4f * y + 2.f * z, 2.6f},
                             {0.2f * x + 2.1f * y + 2.5f * z, 4.4f}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if(j == matrix[i].length - 1){
                    System.out.println(" ≈ " + matrix[i][j]);
                    break;
                }
                System.out.print("\t" + matrix[i][j]);
            }
        }
    }
}