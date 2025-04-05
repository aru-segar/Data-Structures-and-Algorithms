package tutorial03;

public class Matrices {

    public static void printMatrix(int[][] matrix) {
        int dimension = matrix.length;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int dimension = A.length;
        int[][] result = new int[dimension][dimension];
        System.out.println("Multiplying matrices:");
        printMatrix(A);
        printMatrix(B);

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[i][j] = 0;
                for (int k = 0; k < dimension; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("Result of multiplication:");
        printMatrix(result);

        return result;
    }

    // Brute force version of matrix power
    public static int[][] slowPower(int[][] matrix, int exponent) {
        System.out.println("Calculating slowPower with exponent: " + exponent);
        int dimension = matrix.length;
        int[][] result = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            result[i][i] = 1;
        }

        for (int i = 0; i < exponent; i++) {
            System.out.println("Multiplication " + (i + 1));
            result = multiply(result, matrix);
        }

        return result;
    }

    // Divide-and-conquer version of matrix power
    public static int[][] fastPower(int[][] matrix, int exponent) {
        System.out.println("Calculating fastPower with exponent: " + exponent);

        if (exponent == 1) {
            System.out.println("Base case reached with exponent = 1");
            return matrix;
        } else if (exponent % 2 == 0) {
            System.out.println("Even exponent: " + exponent);
            int[][] halfPower = fastPower(matrix, exponent / 2);
            return multiply(halfPower, halfPower);
        } else {
            System.out.println("Odd exponent: " + exponent);
            int[][] halfPower = fastPower(matrix, (exponent - 1) / 2);
            return multiply(multiply(halfPower, halfPower), matrix);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        int exponent = 5;

        System.out.println("Slow Power:");
        long start = System.currentTimeMillis();
        printMatrix(slowPower(matrix, exponent));
        long middle = System.currentTimeMillis();

        System.out.println("Fast Power:");
        printMatrix(fastPower(matrix, exponent));
        long end = System.currentTimeMillis();

        System.out.println("Runtimes (ms):");
        System.out.println("Slow: " + (middle - start));
        System.out.println("Fast: " + (end - middle));
    }
}
