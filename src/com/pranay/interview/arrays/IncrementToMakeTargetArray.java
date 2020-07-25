package com.pranay.interview.arrays;

/**
 * 1526. Minimum Number of Increments on Subarrays to Form a Target Array
 * https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 *
 * Explanation:
 * Whenever the current element a is bigger than the previous element,
 * we need at lease a - pre operations to make this difference.
 *
 * We accumulate the total number of the operations,
 * this result is a lower bound and it's feasible.
 *
 *
 * Complexity
 * Time O(N)
 * Space O(1)
 */
public class IncrementToMakeTargetArray {
    public static void main(String[] args) {
        int[] target = {1,2,3,2,1};
        int count = minNumberOperations(target);
        System.out.println("Ans : " + count);
    }

    private static int minNumberOperations(int[] target) {
        int prev = 0;
        int ops = 0;

        for (int A: target) {
            ops += Math.max(0, A - prev);
            prev = A;
        }
        return ops;

    }
}
