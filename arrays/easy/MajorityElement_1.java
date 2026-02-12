/*
PS:
- Find the Majority Element that occurs more than N/2 times

Link:
- https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times

*/
package arrays.easy;

public class MajorityElement_1 {
    public static int majorityElement_BruteForce(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > (n / 2)) {
                return arr[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };

        int ans = majorityElement_BruteForce(arr);
        System.out.println("The majority element is: " + ans);
    }
}
