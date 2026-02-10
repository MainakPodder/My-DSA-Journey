/*
Problem: 
- Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, Else return False.

Link:
- https://takeuforward.org/data-structure/check-if-an-array-is-sorted
*/

package arrays.basic;

public class CheckIfAnArrayIsSorted {
    public static boolean isSorted_BruteForce(int[] arr) {
        // TC: O(N^2), SC: O(1)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // If any element is greater than the next one
                if (arr[i] > arr[j]) {
                    return false;
                }
            }
        }
        // If no unsorted elements
        return true;
    }

    public static boolean isSorted_Optimal(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        // boolean isSorted = isSorted_BruteForce(arr);
        boolean isSorted = isSorted_Optimal(arr);

        System.out.println("Array is sorted: " + isSorted);
    }
}
