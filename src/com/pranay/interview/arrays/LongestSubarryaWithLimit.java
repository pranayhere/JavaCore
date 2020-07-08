package com.pranay.interview.arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray
 * such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 *
 * Example 1:
 *
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 *
 * Example 2:
 *
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 */

public class LongestSubarryaWithLimit {
    public static void main(String[] args) {
        int[] nums = {10,1,2,4,7,2};
        int limit = 0;

        int size = longestSubarrayDeque(nums, limit);
        System.out.println("Subarray Size : " + size);
    }

    private static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            tm.put(nums[j], tm.getOrDefault(nums[j], 0) + 1);

            if (tm.lastKey() - tm.firstKey() > limit) {
                int count = tm.get(nums[i]);
                if (count == 1)
                    tm.remove(nums[i]);
                else
                    tm.put(nums[i], count - 1);
                i++;
            } else {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    private static int longestSubarrayDeque(int[] nums, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();

        int i = 0, j;
        for (j = 0; j < nums.length; j++) {

            while (!maxd.isEmpty() && nums[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && nums[j] < mind.peekLast()) mind.pollLast();

            maxd.add(nums[j]);
            mind.add(nums[j]);

            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == nums[i]) maxd.poll();
                if (mind.peek() == nums[i]) mind.poll();
                i++;
            }
        }
        return j - i;
    }
}
