package lecture03;

public class BubbleSort {

    public static int[] bubbleSort(int[] list) {
        System.out.println("Original array:");
        printArray(list); // Print the original array
        System.out.println("----------------------");

        for (int i = 0; i < list.length; i++) { // Loop through the array
            System.out.println("\nIteration " + (i + 1) + ":");
            boolean swapped = false; // Initialize swapped to false for each iteration

            for (int j = 0; j < list.length - i - 1; j++) { // Loop through the unsorted part of the array
                System.out.println("Comparing list[" + j + "] = " + list[j] + " with list[" + (j + 1) + "] = " + list[j + 1]);

                if (list[j] > list[j + 1]) { // Check if the current element is greater than the next element
                    System.out.println("Swapping " + list[j] + " and " + list[j + 1]); // Print swap message
                    int temp = list[j]; // Store the current element in a temporary variable
                    list[j] = list[j + 1]; // Swap the current element with the next element
                    list[j + 1] = temp; // Assign the temporary variable to the next element
                    swapped = true; // Set swapped to true if a swap occurred
                } else {
                    System.out.println("No swap needed.");
                }

                System.out.print("Array state: ");
                printArray(list); // Print the array after each comparison
            }

            if (!swapped) { // If no swaps occurred, the array is sorted
                System.out.println("No swaps occurred, array is sorted. Exiting loop.");
                break; // Exit the loop
            } else {
                System.out.println("End of iteration " + (i + 1) + ", array is not yet sorted.");
            }
        }

        System.out.println("\nFinal sorted array:");
        printArray(list); // Final result
        return list; // Return the sorted array
    }

    public static void printArray(int[] list) {
        for (int i = 0; i < list.length; i++) { // Loop through the array
            System.out.print(list[i] + " "); // Print each element
        }
        System.out.println(); // Print a new line after printing the array
    }

    public static void main(String[] args) {
        int[] list = {5, 2, 9, 1, 5, 6}; // Example array to sort
        bubbleSort(list); // Call the bubbleSort method to sort the array
    }
}
