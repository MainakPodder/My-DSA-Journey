/*
Link:
- https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero
- https://dsa.apnacollege.in/3sum
*/

import java.util.*;

class ThreeSum {
    // TC: O(N^3*(logK)) -> k is no. of unique triplets
    // SC: O(K)
    // Using Nested Loops
    public static List<List<Integer>> threeSum_BruteForce(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if (sum == 0) {
                        set.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }

        result.addAll(set);
        return result;
    }

    // TC: O(N^2*(logK)) -> k is no. of unique triplets
    // SC: O(K)
    // Using Two-Pointer and Set
    public static List<List<Integer>> threeSum_Better1(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int n = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            int target = -arr[i];

            while (left < right) {
                int sum = arr[left] + arr[right];

                if (sum == target) {
                    // Find triplet
                    set.add(Arrays.asList(arr[i], arr[left], arr[right]));

                    left++;
                    right--;
                } else if (sum > target) {
                    right--; // - need a smaller number
                } else {
                    left++; // - need a bigger number
                }
            }
        }

        result.addAll(set);
        return result;
    }

    // TC: O(N^2*(logK)) -> k is no. of unique triplets
    // SC: O(K)
    // Using Set
    public static List<List<Integer>> threeSum_Better2(int[] arr) {
        int length = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < length; i++) {
            Set<Integer> seenNumbers = new HashSet<>();
            for (int j = i + 1; j < length; j++) {
                int firstNum = arr[i];
                int secondNum = arr[j];
                int requiredNum = -(firstNum + secondNum);

                if (seenNumbers.contains(requiredNum)) {
                    List<Integer> triplet = Arrays.asList(firstNum, secondNum, requiredNum);
                    Collections.sort(triplet); // ensure consistent order
                    uniqueTriplets.add(triplet);
                }

                seenNumbers.add(secondNum);
            }
        }

        result.addAll(uniqueTriplets);
        return result;
    }

    // TC: O(N^2)
    // SC: O(1)
    // Using Two-Pointer and Set
    public static List<List<Integer>> threeSum_Best(int[] arr) {
        int length = arr.length;
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < length; i++) {
            // [-4, -1, -1, 0, 1, 2] -> skip 2nd -1
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int targetSum = -arr[i];
            int leftPointer = i + 1;
            int rightPointer = length - 1;

            while (leftPointer < rightPointer) {
                int currentSum = arr[leftPointer] + arr[rightPointer];

                if (currentSum == targetSum) {
                    triplets.add(Arrays.asList(arr[i], arr[leftPointer], arr[rightPointer]));

                    // Skip duplicate values
                    if (leftPointer < rightPointer && arr[leftPointer] == arr[leftPointer + 1])
                        leftPointer++;
                    if (leftPointer < rightPointer && arr[rightPointer] == arr[rightPointer - 1])
                        rightPointer++;

                    leftPointer++;
                    rightPointer--;
                } else if (currentSum < 0) {
                    // If sum is too small, move leftPointer forward to increase sum
                    leftPointer++;
                } else {
                    // If sum is too large, move rightPointer backward to decrease sum
                    rightPointer--;
                }
            }
        }

        return triplets;
    }

    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };

        // List<List<Integer>> result = threeSum_BruteForce(arr);
        // List<List<Integer>> result = threeSum_Better1(arr);
        List<List<Integer>> result = threeSum_Better2(arr);
        // List<List<Integer>> result = threeSum_Best(arr);

        printResult(result);
    }
}