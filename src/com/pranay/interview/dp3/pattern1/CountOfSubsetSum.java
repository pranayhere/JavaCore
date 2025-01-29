package com.pranay.interview.dp3.pattern1;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubsetSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 8, 10}; // [2,3,5] [2,8] [10]
        int sum = 10;

        CountOfSubsetSum cs = new CountOfSubsetSum();
        int count = cs.count(nums, sum, nums.length);
        System.out.println("Ans: " + count);

        int countMemo = cs.countMemo(nums, sum, nums.length);
        System.out.println("Memo ans: " + countMemo);

    }

    public int count(int[] nums, int sum, int n) {
        if (sum == 0)
            return 1;

        if (n == 0)
            return 0;

        if (nums[n - 1] <= sum) {
            return count(nums, sum - nums[n - 1], n - 1) + count(nums, sum, n - 1);
        } else {
            return count(nums, sum, n - 1);
        }
    }

    Map<String, Integer> dp = new HashMap<>();
    public int countMemo(int[] nums, int sum, int n) {
        if (sum == 0)
            return 1;

        if (n == 0)
            return 0;

        String key = sum + "_" + n;
        if (dp.containsKey(key))
            return dp.get(key);

        int count = 0;
        if (nums[n - 1] <= sum) {
            count = countMemo(nums, sum - nums[n - 1], n - 1) + countMemo(nums, sum, n - 1);
        } else {
            count = countMemo(nums, sum, n - 1);
        }

        dp.put(key, count);
        return count;
    }
}
