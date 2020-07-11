package com.pranay.interview.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 659. Split Array into Consecutive Subsequences
 * <p>
 * Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences
 * such that each subsequence consists of consecutive integers and has length at least 3.
 * <p>
 * Example 1:
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * Example 3:
 * <p>
 * Input: [1,2,3,4,4,5]
 * Output: False
 * <p>
 * Explaination
 * 1. We iterate through the array once to get the frequency of all the elements in the array
 * 2. We iterate through the array once more and for each element we either
 * see if it can be appended to a previously constructed consecutive sequence
 * or if it can be the start of a new consecutive sequence. If neither are true, then we return false.
 */

public class SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 4, 5};
        boolean ans = isPossible(nums);
        System.out.println("Ans : " + ans);
    }

    private static boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int i : nums) {
            if (freq.get(i) == 0)
                continue;

            else if (end.getOrDefault(i, 0) > 0) {
                end.put(i, end.get(i) - 1); // reduce the count
                end.put(i + 1, end.getOrDefault(i + 1, 0) + 1); // could be possible end
            } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                end.put(i + 3, end.getOrDefault(i + 3, 0) + 1); // could be possible end
            } else
                return false;

            freq.put(i, freq.get(i) - 1);
        }

        return true;
    }
}
