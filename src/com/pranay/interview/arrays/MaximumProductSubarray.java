package com.pranay.interview.arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        int ans = maxProduct(arr);
        System.out.println("Maximum product Subarray is : " +ans);
    }

    /**
     * First, if there's no zero in the array, then the subarray with maximum product must start with the first element or end with the last element.
     * And therefore, the maximum product must be some prefix product or suffix product. So in this solution, we compute the prefix product A and suffix product B,
     * and simply return the maximum of A and B.
     *
     * TL;DR ) is the only important case;
     */
    private static int maxProduct(int[] A) {
        int product = 1;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            product *= A[i];
            res = Math.max(res, product);

            if (product == 0)
                product = 1;
        }

        product = 1;

        for (int i = A.length - 1; i >= 0; i--) {
            product *= A[i];
            res = Math.max(res, product);

            if (product == 0)
                product = 1;
        }

        return res;
    }
}
