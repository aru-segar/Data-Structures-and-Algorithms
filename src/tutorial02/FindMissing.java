package tutorial02;

import java.util.ArrayList;
import java.util.Collections;

public class FindMissing {

    /*
     * Find the smallest missing nonnegative value in an unsorted array
     */
    // O(n^2) time complexity
    public static int findMissingUnsorted(ArrayList<Integer> numbers) {
        for (int i = 0; i <= numbers.size(); i++) { // Loop through the arraylist
            if (!numbers.contains(i)) { // Check if the number is missing
                System.out.println("Missing number found: " + i);
                return i; // Return the missing number
            }
        }
        return -1;  // Dummy value
    }

    /*
     * Find the smallest missing nonnegative value in a sorted array
     */
    // O(n) time complexity
    public static int findMissingSorted(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) { // Loop through the arraylist
            if (numbers.get(i) != i) { // Check if the number is missing
                System.out.println("Missing number found: " + i);
                return i; // Return the missing number
            }
        }
        return -1;  // Dummy value
    }

    public static ArrayList<Integer> createInput(int size, boolean shuffle) {
        ArrayList<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(i);
        }
        if (shuffle) {
            Collections.shuffle(result);
        }
        return result;
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 10;
        // Whether to print data. Only use with small numbers of values.
        boolean printData = true;
        // Whether to sort the data
        boolean sort = false;

        // Create some data, either sorted or unsorted
        ArrayList<Integer> data = createInput(numValues, true);
        // Optionally print the data (to check correctness)
        if (printData) {
            System.out.print("Input values: ");
            for (int i = 0; i < data.size(); i++) {
                System.out.print(data.get(i) + " ");
            }
            System.out.println();
        }

        if (sort) {
            Collections.sort(data);
        }

        // Run the find function; 
        // Check time before and after to measure runtime 
        long start = System.currentTimeMillis();
        int result;
        if (sort) {
            result = findMissingSorted(data);
        } else {
            result = findMissingUnsorted(data);
        }
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;

        if (result >= 0) {
            if (result < data.size()) {
                System.out.println("Result: " + result + " (value: " + data.get(result) + ")");
            } else {
                System.out.println("Result: " + result + " (value: not in data)");
            }
        } else {
            System.out.println("Result: nothing found");
        }

        System.out.println("Elapsed time = " + elapsed + " seconds");
    }
}
