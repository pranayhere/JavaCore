package com.pranay.GeeksForGeeks;

public class MaxProductOfTwoElementsInArray {
    public static void main(String[] args) {
        int[] nums = {1,5,4,5};
        int product = maxProduct(nums);
        System.out.println("Product : " + product);
    }

    private static int maxProduct(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int maxProd = -1;
        while (lo < hi) {
            int prod = (nums[lo] - 1) * (nums[hi] - 1);
            maxProd = Math.max(prod, maxProd);
            if (nums[lo] < nums[hi])
                lo++;
            else
                hi--;
        }
        return maxProd;
    }
}
