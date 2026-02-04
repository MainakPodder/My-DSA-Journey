/*
Problem: 
- Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].

Link:
- https://takeuforward.org/data-structure/count-reverse-pairs

Note:
- 

*/
public class CountReversePairs {
    // TC: O(n^2), SC: O(1)
    public static int countPairs_BruteForce(int[] a, int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > 2 * a[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countPairs_Optimal(int[] a, int n) {
        return 0;
    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 2, 3, 1 };
        int n = 5;

        // Total Pairs Found: ((4,1),(3,1),(4,1)) = 3.
        int count = countPairs_BruteForce(a, n);
        // int count = countPairs_Optimal(a, n);

        System.out.println("The number of reverse pair is: " + count);
    }
}