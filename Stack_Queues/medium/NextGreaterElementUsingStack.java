package Stack_Queues.medium;

import java.util.Stack;

public class NextGreaterElementUsingStack {

    public static int[] getNextGreaterElement(int[] nums) {
        Stack<Integer> stk = new Stack<>();

        int n = nums.length;
        int[] res = new int[n];

        for (int i = n-1; i >= 0; i--) {
            while (!stk.empty() && (stk.peek() <= nums[i])) { // stack peek <= array element
                stk.pop();
            }

            if (stk.empty()) {
                res[i] = -1;
            }else{ // stack peek > array element
                res[i] = stk.peek();
            }

            stk.push(nums[i]);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10};
        int[] ans = getNextGreaterElement(nums);

        for (int x : ans) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
