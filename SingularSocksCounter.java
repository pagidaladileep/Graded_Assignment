// Question 3: Find the count of singulars in array -

// Skill Mapping: Expert

// Description: Consider data with assorted details of socks pair IDs. Each element in the array represents a number of similar pairs. You will have to find out how many singular socks are present which do not have any pair left.

// Sample input: arrNum = {10, 20, 20, 10, 10, 30, 50, 10, 20}

// Output: Count of singular socks = 3

// Explanation : Socks Id - 10: total count 4 => Two pairs of socks - no singular left

// Socks Id - 20: total count 3 => One pair of socks - 1 singular left

// Socks Id - 30: total count 1 => No pair of socks - 1 singular left

// Socks Id - 50: total count 1 => No pair of socks - 1 singular left

// So, Total number of Singular socks = 3



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingularSocksCounter {

    public static int countSingularSocks(int[] arrNum) {
        Map<Integer, Integer> sockPairs = new HashMap<>();
        int singularSocksCount = 0;

        // Count the occurrences of each sock ID in the array
        for (int sockID : arrNum) {
            sockPairs.put(sockID, sockPairs.getOrDefault(sockID, 0) + 1);
        }

        // Count the number of singular socks
        for (int count : sockPairs.values()) {
            if (count % 2 != 0) {
                singularSocksCount++;
            }
        }

        return singularSocksCount;
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

        int singularSocksCount = countSingularSocks(arrNum);
        System.out.println("Count of singular socks = " + singularSocksCount);
    }
}

