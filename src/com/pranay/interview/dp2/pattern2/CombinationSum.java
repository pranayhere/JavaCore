package com.pranay.interview.dp2.pattern2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {29,65,70,100,153,172,186,195,220,237,245};
        int target = 195;

        CombinationSum cs = new CombinationSum();
        List<List<Integer>> ans = cs.combinationSum(candidates, target);
        System.out.println("Ans : " + ans);
    }

    Set<List<Integer>> ans = new HashSet<>();
    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();

        dfs(candidates, target, candidates.length, curr);

        return new ArrayList<>(ans);
    }

    private void dfs(int[] nums, int W, int n, List<Integer> curr) {
        if (W == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (n == 0 || W < 0) {
            return;
        }

        List<Integer> tmp = new ArrayList<>(curr);
        curr.add(nums[n - 1]);

        if (nums[n - 1] <= W) {
            dfs(nums, W - nums[n - 1], n - 1, curr);
            dfs(nums, W - nums[n - 1], n, curr);
            dfs(nums, W, n - 1, tmp);
        } else {
            dfs(nums, W, n - 1, tmp);
        }

        curr.remove(curr.size() - 1);
    }
}
