package com.pranay.interview.graph;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * To find the shortest required operations that sum up to x is to find the longest subarray that sums up to total - x.
 */
public class MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        int[] nums = {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        int x = 134365;

        // expected ans 16, wrong test case?
        MinimumOperationsToReduceXToZero minops = new MinimumOperationsToReduceXToZero();
        int ans = minops.minOperations2(nums, x); // dfs solution is incorrect
        System.out.println("Ans : " + ans);
    }

    int minOps = Integer.MAX_VALUE;

    public int minOperations(int[] nums, int x) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[lo] > x && nums[hi] > x)
            return -1;

        dfs(nums, x, lo, hi, 0);
        return minOps == Integer.MAX_VALUE ? -1 : minOps;
    }

    private void dfs(int[] nums, int x, int lo, int hi, int count) {
        if (x < 0)
            return;

        if (lo > hi)
            return;

        if (x == 0) {
            minOps = Math.min(minOps, count);
            return;
        }

        if (x >= nums[lo]) {
            dfs(nums, x - nums[lo], lo + 1, hi, count + 1);
        }

        if (x >= nums[hi]) {
            dfs(nums, x - nums[hi], lo, hi - 1, count + 1);
        }
    }

    public int minOperations2(int[] nums, int x) {
        int total = 0;
        for (int n: nums)
            total += n;

        int n = nums.length;
        int maxi = -1;
        int left = 0;
        int current = 0;

        for (int right = 0; right < nums.length; right++) {
            current += nums[right];

            while (current > total - x && left <= right) {
                current -= nums[left];
                left++;
            }

            if (current == total - x) {
                maxi = Math.max(maxi, right - left + 1);
            }
        }

        return maxi != -1 ? n - maxi : -1;
    }
}
