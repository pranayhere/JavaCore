package com.pranay.interview.dp3.pattern1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each
 * integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them
 * to build the expression "+2-1".Return the number of different expressions that you can build, which
 * evaluates to target.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;

        TargetSum s = new TargetSum();
        int ans = s.targetSum(nums, target, nums.length);

        System.out.println("Ans: " + ans);

        int ans2 = s.targetSumMemo(nums, target, nums.length);
        System.out.println("Memo Ans: " + ans2);
    }

    public int targetSum(int[] nums, int target, int n) {
        if (n == 0 && target == 0)
            return 1;

        if (n == 0)
            return 0;

        return targetSum(nums, target + nums[n - 1], n - 1) + targetSum(nums, target - nums[n - 1], n - 1);
    }


    Map<String, Integer> hm = new HashMap<>();
    private int targetSumMemo(int[] nums, int target, int n) {
        return targetMemo(nums, target, n);
    }

    public int targetMemo(int[] nums, int target, int n) {
        if (n == 0 && target == 0)
            return 1;

        if (n == 0)
            return 0;

        String key = target + "_" + n;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }

        int count = targetMemo(nums, target + nums[n - 1], n - 1) + targetMemo(nums, target - nums[n - 1], n - 1);
        hm.put(key, count);

        return count;
    }
}
