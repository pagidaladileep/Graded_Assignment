// Question 1: Cumulative Multiple of an Array with exception handling

// Skill Mapping: Basic

// Description: Consider an Array with N number of integers.

// Task 1- WAP in Java to calculate cumulative multiple at each index.

// Task 2 – Push the result into the same Array and Print.

// Task 3 - Handle the exceptions in program

// Sample input: arrNum = [5, 3, 4, 2, 0, 8]

// Output:- arrNum = [5, 15, 60, 120, 0, 0]

// Explanation:- arrNum[0] -> C.M. = 5

// arrNum[1] -> C.M. = 5 x 3

// arrNum[2] -> C.M. = 5 x 3 x 4

// arrNum[3] -> C.M. = 5 x 3 x 4 x 2

// arrNum[4] -> C.M. = 5 x 3 x 4 x 2 x 0

// arrNum[5] -> C.M. = 5 x 3 x 4 x 2 x 0 x 8


import java.util.Arrays;
import java.util.Scanner;

public class CumulativeMultipleCalculator {

    public static void calculateCumulativeMultiple(int[] arrNum) {
        if (arrNum == null || arrNum.length == 0) {
            throw new IllegalArgumentException("Input array is empty or null.");
        }

        int cumulativeMultiple = 1;
        for (int i = 0; i < arrNum.length; i++) {
            cumulativeMultiple *= arrNum[i];
            arrNum[i] = cumulativeMultiple;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arrNum = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arrNum[i] = scanner.nextInt();
        }

        scanner.close();

        try {
            calculateCumulativeMultiple(arrNum);
            System.out.println("Output:- arrNum = " + Arrays.toString(arrNum));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
