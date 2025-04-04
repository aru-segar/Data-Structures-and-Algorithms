package tutorial01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class FindMultiples {

    /*
     * Find an index where a value in the array occurs for the second time
     * Returns -1 if no such index exists
     */
    public static int findDuplicate(ArrayList<Integer> numbers) {
        System.out.println("Starting findDuplicate...");
        for (int i = 0; i < numbers.size(); i++) { // Loop through the arraylist
            System.out.println("Checking index " + i + " (value: " + numbers.get(i) + ")");
            for (int j = 0; j < i; j++) {  // Loop through the arraylist again
                System.out.println("   Comparing with index " + j + " (value: " + numbers.get(j) + ")");
                if (Objects.equals(numbers.get(i), numbers.get(j))) { // Check for duplicate
                    System.out.println("   ➤ Duplicate found at index " + i + " (value: " + numbers.get(i) + ")");
                    return i; // Return the index of the duplicate number
                }
            }
        }
        System.out.println("No duplicate found.");
        return -1;  // Failure case
    }

    /*
     * Find an index where a value in the array occurs for the third time
     * Returns -1 if no such index exists
     */
    public static int findTriplicate(ArrayList<Integer> numbers) {
        System.out.println("Starting findTriplicate...");
        for (int i = 0; i < numbers.size(); i++) { // Loop through the arraylist
            int count = 0; // Reset the count for each number
            System.out.println("Checking index " + i + " (value: " + numbers.get(i) + ")");
            for (int j = 0; j < i; j++) { // Loop through the arraylist again
                System.out.println("   Comparing with index " + j + " (value: " + numbers.get(j) + ")");
                if (Objects.equals(numbers.get(i), numbers.get(j))) { // Check for duplicate
                    count++; // Increment count
                    System.out.println("   ➤ Match found. Count = " + count);
                }
            }
            if (count == 2) { // If the count reaches 2, it's the third occurrence
                System.out.println("   ➤ Triplicate found at index " + i + " (value: " + numbers.get(i) + ")");
                return i; // Return the index of the triplicate number
            }
        }
        System.out.println("No triplicate found.");
        return -1;  // Failure case
    }

    public static ArrayList<Integer> createInput(int size, int repeats, boolean shuffle) {
        System.out.println("Creating input: size = " + size + ", repeats = " + repeats + ", shuffle = " + shuffle);
        ArrayList<Integer> result = new ArrayList<>(size);
        for (int i = repeats; i < size; i++) {
            result.add(i);
        }
        for (int i = 0; i < repeats; i++) {
            result.add(0);
        }
        if (shuffle) {
            System.out.println("Shuffling the input array...");
            Collections.shuffle(result);
        }
        System.out.println("Input creation complete.");
        return result;
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("---- Program Start ----");

        // How many values to generate
        int numValues = 10;
        // Whether the input should be shuffled
        boolean shuffle = true;
        // Whether to look for triplicate values
        boolean triplicates = false;
        // Whether to print data. Only use with small numbers of values.
        boolean printData = true;

        // Create some data, either sorted or unsorted
        ArrayList<Integer> data = createInput(numValues, (triplicates ? 3 : 2), shuffle);

        // Optionally print the data (to check correctness)
        if (printData) {
            System.out.print("Input values: ");
            for (int i = 0; i < data.size(); i++) {
                System.out.print(data.get(i) + " ");
            }
            System.out.println();
        }

        // Run one of the find functions; 
        // Check time before and after to measure runtime 
        long start = System.currentTimeMillis();
        System.out.println("Starting search...");
        int result = triplicates ? findTriplicate(data) : findDuplicate(data);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;

        if (result >= 0) {
            System.out.println("Result: " + result + " (value: " + data.get(result) + ")");
        } else {
            System.out.println("Result: nothing found");
        }

        System.out.println("Elapsed time = " + elapsed + " seconds");
        System.out.println("---- Program End ----");
    }
}
