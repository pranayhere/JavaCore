package com.pranay.interview.stacks;

import java.util.Stack;
import java.util.Stack;

/**
 * Every Sublist Min Sum
 * https://binarysearch.com/problems/Every-Sublist-Min-Sum
 * You are given a list of integers nums. Return the sum of min(x) for every sublist x in nums. Mod the result by 10 ** 9 + 7.
 *
 * Constraints
 *
 * n ≤ 100,000 where n is the length of nums
 * Example 1
 * Input
 * nums = [1, 2, 4, 3]
 * Output
 * 20
 * Explanation
 * We have the following sublists and their mins:
 *
 * min([1]) = 1
 * min([1, 2]) = 1
 * min([1, 2, 4]) = 1
 * min([1, 2, 4, 3]) = 1
 * min([2]) = 2
 * min([2, 4]) = 2
 * min([2, 4, 3]) = 2
 * min([4]) = 4
 * min([4, 3]) = 3
 * min([3]) = 3
 *
 *
 * Solution:
 * https://www.geeksforgeeks.org/sum-of-minimum-elements-of-all-possible-sub-arrays-of-an-array/
 */

public class SumOfSubarrayMinimum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        int sum = sumOfSubarrayMin(nums);
        System.out.println("Sum : " + sum);
    }

    private static int sumOfSubarrayMin(int[] nums) {
        int n = nums.length;

        int[] CL = new int[n]; // count left
        int[] CR = new int[n]; // count right

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                CL[i] += CL[stk.peek()] + 1;
                stk.pop();
            }
            stk.push(i);
        }

        stk.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                CR[i] += CR[stk.peek()] + 1;
                stk.pop();
            }
            stk.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (CL[i] + 1) * (CR[i] + 1) * nums[i];
        }

        return ans;
    }
}
