package lecture03;

public class SelectionSort {
    public static int[] selectionSort(int[] list) {
        System.out.println("Original array:");
        printArray(list); // Print the original array

        for (int i = 0; i < list.length; i++) { // Loop through the array
            int max_index = 0; // Initialize max_index to 0
            System.out.println("\nPass " + (i + 1) + ":");

            for (int j = 0; j < list.length - i; j++) { // Loop through the unsorted part of the array
                System.out.println("Comparing list[" + j + "] = " + list[j] + " with list[" + max_index + "] = " + list[max_index]);
                if (list[j] > list[max_index]) { // Check if the current element is greater than the current max
                    max_index = j; // Update max_index to the current index
                    System.out.println("New max found at index " + max_index + " = " + list[max_index]);
                }
            }

            // Swap the maximum element with the last unsorted element
            System.out.println("Swapping max element " + list[max_index] + " at index " + max_index + 
                               " with element " + list[list.length - i - 1] + " at index " + (list.length - i - 1));
            
            int temp = list[max_index]; // Store the maximum element in a temporary variable
            list[max_index] = list[list.length - i - 1]; // Swap the maximum element with the last unsorted element
            list[list.length - i - 1] = temp; // Assign the temporary variable to the last unsorted element

            System.out.print("Array after pass " + (i + 1) + ": ");
            printArray(list); // Print the array after each swap    
        }

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
        selectionSort(list); // Call the selectionSort method to sort the array
    }
}
