package lecture01;

import java.util.Scanner;

public class EvenNumber {
    public static void main (String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter a number: ");
            int number = input.nextInt();
            checkEven(number);
        }

    }

    public static void checkEven(int number) {
        if(number % 2 == 0) {
            System.out.println("The number is an even number.");
        } else {
            System.out.println("The number is an odd number.");
        }
    }
}