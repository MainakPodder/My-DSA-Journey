/*
Problem: 
- Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

Link:
- https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero
- https://dsa.apnacollege.in/3sum
*/

import java.util.*;

class ThreeSum {
    // TC: O(N^3*(logK)) -> k is no. of unique triplets
    // SC: O(K)
    public static List<List<Integer>> threeSum_BruteForce(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
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

    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> result = threeSum_BruteForce(arr);

        printResult(result);
    }
}