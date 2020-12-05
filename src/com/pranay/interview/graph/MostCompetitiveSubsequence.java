package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostCompetitiveSubsequence {
    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 3, 5, 4, 9, 6};
        int k = 4;

        MostCompetitiveSubsequence mcs = new MostCompetitiveSubsequence();
        int[] ans = mcs.mostCompetitive(nums, k);
        System.out.println("Ans : " + Arrays.toString(ans));
    }

    List<List<Integer>> allLis = new ArrayList<>();
    private int[] mostCompetitive(int[] nums, int k) {
        dfs(nums, 0, k, new ArrayList<>());

        System.out.println(allLis);
        return new int[0];
    }

    private void dfs(int[] nums, int idx, int k, ArrayList<Integer> curr) {
        if (curr.size() == k) {
            allLis.add(new ArrayList<>(curr));
            return;
        }

        if (idx == nums.length)
            return;

        int size = curr.size();
        
        if (curr.isEmpty() || curr.get(curr.size() - 1) <= nums[idx]) {
            curr.add(nums[idx]);
            dfs(nums, idx + 1, k, curr);
        }

        dfs(nums, idx + 1, k, curr);


        if (curr.size() > size)
            curr.remove(curr.size() - 1);
    }
}
