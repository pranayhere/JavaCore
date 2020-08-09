package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. Increasing Subsequences
 * https://leetcode.com/problems/increasing-subsequences/
 */
public class IncreasingSubsequences {
    public static void main(String[] args) {
        int[] nums = {4, 6, 7, 7};
        IncreasingSubsequences is = new IncreasingSubsequences();
        List<List<Integer>> ans = is.findSubsequences(nums);
        System.out.println("Ans : " + ans);
    }

    Set<List<Integer>> res = new HashSet<>();

    private List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    public void dfs(int[] nums, int idx, List<Integer> curr) {
        if (curr.size() > 1)
            res.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; i++) {
            if (curr.size() == 0 || nums[i] >= curr.get(curr.size() - 1)) {
                curr.add(nums[i]);
                dfs(nums, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
