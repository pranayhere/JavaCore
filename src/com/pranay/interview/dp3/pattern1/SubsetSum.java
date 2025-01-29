package com.pranay.interview.dp3.pattern1;

public class SubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,4};
        int sum = 7;

        SubsetSum ss = new SubsetSum();
        boolean exist = ss.subsetSum(nums, sum, nums.length);
        System.out.println("Subset sum exist="+ exist);
    }

    public boolean subsetSum(int[] nums, int sum, int n) {
        if (sum == 0)
            return true;

        if (n == 0)
            return false;

        if (nums[n - 1] <= sum) {
            return subsetSum(nums, sum - nums[n - 1], n - 1) || subsetSum(nums, sum, n - 1);
        } else {
            return subsetSum(nums, sum, n - 1);
        }
    }
}
