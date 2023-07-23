// Question 2: Find missing numbers in array -

// Skill Mapping: Basic

// Description: Consider an array with N number of consecutive integers, in which few numbers are missing. Find and list down these missing numbers using Java.

// Sample input: arrNum = {1, 2, 4, 5, 6}

// Output: 3

// Sample input: arrNum = {1, 2, 3, 5, 6, 8, 10, 11, 14}

// Output: 4, 7, 9, 12, 13


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MissingNumbersFinder {

    public static List<Integer> findMissingNumbers(int[] arrNum) {
        List<Integer> missingNumbers = new ArrayList<>();
        
        int expectedNumber = arrNum[0];
        for (int num : arrNum) {
            while (num > expectedNumber) {
                missingNumbers.add(expectedNumber);
                expectedNumber++;
            }
            expectedNumber++;
        }
        
        return missingNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arrNum = new int[n];

        System.out.println("Enter the elements of the array in ascending order:");
        for (int i = 0; i < n; i++) {
            arrNum[i] = scanner.nextInt();
        }

        scanner.close();

        List<Integer> missingNumbers = findMissingNumbers(arrNum);
        System.out.println("Output: " + Arrays.toString(missingNumbers.toArray()));
    }
}
