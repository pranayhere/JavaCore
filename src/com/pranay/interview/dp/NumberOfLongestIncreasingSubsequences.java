package com.pranay.interview.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfLongestIncreasingSubsequences {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        NumberOfLongestIncreasingSubsequences s = new NumberOfLongestIncreasingSubsequences();
        int count = s.findNumberOfLIS(nums);
        System.out.println("Number of longest increasing subsequences : " + count);
    }

    Set<List<Integer>> seqs = new HashSet<>();

    private int findNumberOfLIS(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        System.out.println(seqs);

        int maxSize = 0;
        int count = 0;
        for (List<Integer> list: seqs) {
            if (list.size() > maxSize) {
                count = 1;
                maxSize = list.size();
            } else if (list.size() == maxSize) {
                count++;
            }
        }
        return count;
    }

    private void dfs(int[] nums, int idx, ArrayList<Integer> curr) {
        if (curr.size() > 1)
            seqs.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; i++) {
            if (curr.size() == 0 || nums[i] > curr.get(curr.size() - 1)) {
                curr.add(nums[i]);
                dfs(nums, i + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
