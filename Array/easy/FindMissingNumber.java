/*
Link:
- https://www.geeksforgeeks.org/dsa/find-the-missing-number/
*/

public class FindMissingNumber {
    /*
     * TC: O(N)
     * SC: O(1)
     */
    public static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int totalNums = n + 1;
        int expectedSum = totalNums * (totalNums + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            actualSum += arr[i];
        }

        int missingElement = expectedSum - actualSum;

        return missingElement;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 2, 4, 5, 3, 7, 1, 9, 6, 11 };

        int result = findMissingNumber(arr);
        System.out.println("The missing element in the array is: " + result);
    }
}
