/*
Problem: 
- Given an array, we have to find the largest element in the array.

Link:
- https://takeuforward.org/data-structure/find-the-largest-element-in-an-array

Note:
- Use arr[0] is efficient (skips one loop); use Integer.MIN_VALUE is safer handling of negative numbers.
*/

package arrays.basic;

import java.util.Arrays;

public class FindLargestElement {
    // TC: O(N log N), SC: O(1)
    public static int findLargestElement_BruteForce(int[] arr1) {
        Arrays.sort(arr1);

        return arr1[arr1.length - 1];
    }

    // TC: O(N), SC: O(1)
    public static int findLargestElement_Optimal(int[] arr2) {
        int max = arr2[0];

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max) {
                max = arr2[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 5, 1, 3, 0 };
        int[] arr2 = { 8, 10, 5, 11, 9 };

        int max1 = findLargestElement_BruteForce(arr1);
        System.out.println("The largest element in the array is: " + max1);

        int max2 = findLargestElement_Optimal(arr2);
        System.out.println("The largest element in the array is: " + max2);
    }
}
