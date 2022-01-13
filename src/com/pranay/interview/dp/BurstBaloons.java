package com.pranay.interview.dp;

import java.util.ArrayList;
import java.util.List;

public class BurstBaloons {
    int ans = 0;

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        BurstBaloons b = new BurstBaloons();
        int ans = b.maxCoins(nums);
        System.out.println("Ans : " + ans);
    }

    public int maxCoins(int[] n) {
        List<Integer> nums = new ArrayList<>();

        for (int val: n) {
            nums.add(val);
        }

        dfs(nums, 0, 0);
        return ans;
    }

    public void dfs(List<Integer> nums, int i, int sum) {
        if (nums.size() == 0) {
            ans = Math.max(sum, ans);
            return;
        }

        if (i >= nums.size()) {
            return;
        }

        int prev = i - 1 < 0 ? 1 : nums.get(i - 1);
        int curr = nums.get(i);
        int next = i + 1 >= nums.size() ? 1 : nums.get(i + 1);

        int currSum = (prev * curr * next) + sum;
        nums.remove(i);
        dfs(nums, i, currSum);
        nums.add(i, curr);
        dfs(nums, i + 1, sum);
    }
}
