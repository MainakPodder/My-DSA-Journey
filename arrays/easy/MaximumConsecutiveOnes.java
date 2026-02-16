/*
Link:
- https://takeuforward.org/data-structure/count-maximum-consecutive-ones-in-the-array
*/
package arrays.easy;

public class MaximumConsecutiveOnes {
    /*
     * TC: O(N)
     * SC: O(1)
     */
    public static int findMaxConsecutiveOnes(int[] arr) {
        int size = arr.length;
        int consecutiveOnes = 0;
        int maxConsecutiveOnes = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] == 1) {
                consecutiveOnes++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, consecutiveOnes);
            } else {
                consecutiveOnes = 0;
            }
        }

        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        int ans = findMaxConsecutiveOnes(nums);

        System.out.println("The maximum consecutive 1's are " + ans);
    }
}
