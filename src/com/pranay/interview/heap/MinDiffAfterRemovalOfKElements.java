package com.pranay.interview.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2163. Minimum Difference in Sums After Removal of Elements
 * https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/
 *
 * Solution:
 * https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/discuss/1747029/Python-Explanation-with-pictures-Priority-Queue.
 *
 *
 */
public class MinDiffAfterRemovalOfKElements {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 2, 1, 7, 3, 6, 1};
        MinDiffAfterRemovalOfKElements md = new MinDiffAfterRemovalOfKElements();
        long ans = md.minimumDifference(nums);
        System.out.println("Ans : " + ans);
    }

    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        long[] minLeft = new long[3 * n];
        long[] maxRight = new long[3 * n];

        long leftSum = 0;
        long rightSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            maxHeap.add(nums[i]);
            leftSum += nums[i];

            if (maxHeap.size() > n)
                leftSum -= maxHeap.poll();

            minLeft[i] = leftSum;
        }

        System.out.println("MinLeft : " + Arrays.toString(minLeft));

        for (int i = nums.length - 1; i >= n; i--) {
            minHeap.add(nums[i]);
            rightSum += nums[i];

            if (minHeap.size() > n)
                rightSum -= minHeap.poll();

            maxRight[i] = rightSum;
        }

        System.out.println("MaxRight : " + Arrays.toString(maxRight));

        long ans = Long.MAX_VALUE;

        for (int i = n - 1; i < 2 * n; i++) {
            ans = Math.min(ans, minLeft[i] - maxRight[i + 1]);
        }

        return ans;
    }
}
