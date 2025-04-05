package tutorial04;

import java.util.Random;

public class BubbleSort {

    public static void sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            boolean swapped = false; // Flag to check if a swap was made
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j + 1]) { // Compare adjacent elements
                    // Swap values[j] and values[j + 1]
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    swapped = true; // Set the flag to true if a swap was made
                }
            }

            if (!swapped) { // If no swaps were made, the array is sorted
                break; // Exit the loop early
            }
        }
    }

    public static int[] randomValues(int howMany) {
        int[] result = new int[howMany];
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            result[i] = random.nextInt() % (10 * howMany);
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 30;
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = true;

        int[] a = randomValues(numValues);
        if (printResults) {
            System.out.print("Before sorting: ");
            for (int i = 0; i < numValues; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        long start = System.currentTimeMillis();
        sort(a);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if (printResults) {
            System.out.print("After sorting: ");
            for (int i = 0; i < numValues; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");
    }
}
