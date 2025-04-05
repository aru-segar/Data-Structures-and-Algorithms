package tutorial04;

import java.util.Random;

public class MergeSort {
    // Merge (sorted) ranges values[first]...values[mid] and values[mid+1]...values[last]

    private static void mergeRanges(int[] values, int first, int mid, int last) {
        int n1 = mid - first + 1; // Number of elements in the first half
        int n2 = last - mid;      // Number of elements in the second half

        int[] left = new int[n1]; // Temporary array for the first half
        int[] right = new int[n2]; // Temporary array for the second half

        for (int i = 0; i < n1; i++) {
            left[i] = values[first + i]; // Copy elements to the left array
        }

        for (int j = 0; j < n2; j++) {
            right[j] = values[mid + 1 + j]; // Copy elements to the right array
        }

        int i = 0; // Initial index of the first half
        int j = 0; // Initial index of the second half
        int k = first; // Initial index of the merged array

        while (i < n1 && j < n2) { // While there are elements in both halves
            if (left[i] <= right[j]) { // Compare elements from both halves
                values[k] = left[i]; // Copy the smaller element to the merged array
                i++; // Move to the next element in the first half
            } else {
                values[k] = right[j]; // Copy the smaller element to the merged array
                j++; // Move to the next element in the second half
            }
            k++; // Move to the next position in the merged array
        }

        while (i < n1) { // If there are remaining elements in the first half
            values[k] = left[i]; // Copy remaining elements to the merged array
            i++;
            k++;
        }

        while (j < n2) { // If there are remaining elements in the second half
            values[k] = right[j]; // Copy remaining elements to the merged array
            j++;
            k++;
        }
    }

    // Auxiliary recursive function
    // Sorts the range values[first]...values[last]
    private static void sortRange(int[] values, int first, int last) {
        if (last > first) {    // Otherwise there is nothing to do (single value)   
            int mid = (first + last) / 2;
            sortRange(values, first, mid);      // Recursively sort first half
            sortRange(values, mid + 1, last);   // Recursively sort second half
            mergeRanges(values, first, mid, last); // Merge sorted halves
        }
    }

    public static void sort(int[] values) {
        sortRange(values, 0, values.length - 1);
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
