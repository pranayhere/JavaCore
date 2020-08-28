package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int len = longestConsecutiveOptimised(nums);
        System.out.println("Longest seq length : " + len);
    }

    // O(n) // glue neighbours
    private static int longestConsecutiveOptimised(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;

        for (int n: nums) {
            if (!hm.containsKey(n)) {
                int l = hm.getOrDefault(n - 1, 0);
                int r = hm.getOrDefault(n + 1, 0);

                int sum = l + r + 1;
                res = Math.max(sum, res);

                hm.put(n, sum);
                hm.put(n - l, sum);
                hm.put(n + r, sum);
            }
        }

        return res;
    }


    // O(n.logn)
    private static int longestConsecutive(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            tm.put(nums[i], tm.getOrDefault(nums[i], 0) + 1);
        }

        int maxCount = 0;
        while (!tm.isEmpty()) {
            int first = tm.firstKey();
            int count = 0;

            for (int i = first; i < first + n; i++) {
                if (tm.containsKey(i)) {
                    count++;

                    if (count > maxCount)
                        maxCount = count;

                    int cnt = tm.get(i);
                    if (cnt == 1)
                        tm.remove(i);
                    else
                        tm.put(i, cnt - 1);
                }
                else {
                    break;
                }
            }
        }

        return maxCount;
    }
}
