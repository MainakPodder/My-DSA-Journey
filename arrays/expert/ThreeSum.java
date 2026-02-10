/*
Problem: 
- Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

Link:
- https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero
- https://dsa.apnacollege.in/3sum

Note:
- Better1: By fixing one element and using two pointers to find the other two numbers that sum to the negative of the fixed element, we can efficiently find triplets.
- Better2: For better approach earlier, we used three loops to find triplets that sum to zero. But now, we aim to do the same using just two loops. To do this, we will calculate the third number needed to complete the triplet instead of looping to find it.
*/

import java.util.*;

class ThreeSum {
    // TC: O(N^3*(logK)) -> k is no. of unique triplets
    // SC: O(K)
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

    // TC: O(N^3*(logK)) -> k is no. of unique triplets
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

    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };

        // List<List<Integer>> result = threeSum_BruteForce(arr);
        List<List<Integer>> result = threeSum_Better1(arr);

        printResult(result);
    }
}