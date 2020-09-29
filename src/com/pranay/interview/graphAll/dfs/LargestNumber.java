package com.pranay.interview.graphAll.dfs;

/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/
 *
 * The idea here is basically implement a String comparator to decide which String should come first during concatenation.
 * Because when you have 2 numbers (let's convert them into String), you'll face only 2 cases:
 * For example:
 *
 * String s1 = "9";
 * String s2 = "31";
 *
 * String case1 =  s1 + s2; // 931
 * String case2 = s2 + s1; // 319
 *
 * Apparently, case1 is greater than case2 in terms of value.
 * So, we should always put s1 in front of s2.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};

        LargestNumber ln = new LargestNumber();
        String ans = ln.largestNumber(nums);
        String ans2 = ln.largestNumberOptimised(nums);
        System.out.println("Largest Number is : " + ans);
        System.out.println("Largest Number is : " + ans2);
    }

    Long max = 0L;
    public String largestNumber(int[] A) {
        List<Integer> nums = new ArrayList<>();
        for (int n: A)
            nums.add(n);

        dfs(nums, 0);
        return max.toString();
    }

    public void dfs(List<Integer> nums, int i) {
        if (i == nums.size() - 1) {
            String str = "";
            for (int n: nums)
                str += n + "";

            Long curr = Long.parseLong(str);
            max = Math.max(curr, max);
        }

        for (int j = i; j < nums.size(); j++) {
            Collections.swap(nums, i, j);
            dfs(nums, i + 1);
            Collections.swap(nums, i, j);
        }
    }


    // optimised
    public String largestNumberOptimised(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] A = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            A[i] = nums[i] + "";

        Arrays.sort(A, (a, b) -> {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        });

        if (A[0].charAt(0) == '0') // edge case: [0, 0] output: 0
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s: A)
            sb.append(s);

        return sb.toString();
    }
}
