package com.pranay.interview.arrays;

public class MaximumSubarrayMinProduct {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        int ans = maxSumMinProduct(nums);
        System.out.println("Ans : " + ans);
    }

    public static int maxSumMinProduct(int[] nums) {
        int N = nums.length;

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum[i] = nums[i] + sum[i - 1];

        int prefix[][] = new int[N][2];
        int suffix[][] = new int[N][2];

        prefixArr(nums, prefix, N);
        suffixArr(nums, suffix, N);

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int min = maxAndmin(prefix, suffix, N, i, j);
                int currSum = sum[j] - (i == 0 ? 0 : sum[i - 1]);
                res = Math.max(currSum * min, res);

                System.out.println("min : " + min + "---" + i + "---" + j + " currSum " + currSum + "---" + res);
            }
        }

        return res;
    }

    public static void prefixArr(int arr[], int prefix[][], int N) {
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                prefix[i][0] = arr[i];
                prefix[i][1] = arr[i];
            } else {
                prefix[i][0] = Math.max(prefix[i - 1][0], arr[i]);
                prefix[i][1] = Math.min(prefix[i - 1][1], arr[i]);
            }
        }
    }

    public static void suffixArr(int arr[], int suffix[][], int N) {
        for (int i = N - 1; i >= 0; i--) {
            if (i == N - 1) {
                suffix[i][0] = arr[i];
                suffix[i][1] = arr[i];
            } else {
                suffix[i][0] = Math.max(suffix[i + 1][0], arr[i]);
                suffix[i][1] = Math.min(suffix[i + 1][1], arr[i]);
            }
        }
    }

    public static int maxAndmin(int prefix[][], int suffix[][], int N, int L, int R) {
        int maximum, minimum;
        if (L == 0 && R == N - 1) {
            return 0;
        } else if (L == 0) {
            maximum = suffix[R + 1][0];
            minimum = suffix[R + 1][1];
        } else if (R == N - 1) {
            maximum = prefix[L - 1][0];
            minimum = prefix[R - 1][1];
        } else {
            maximum = Math.max(prefix[L - 1][0], suffix[R + 1][0]);
            minimum = Math.min(prefix[L - 1][1], suffix[R + 1][1]);
        }

        System.out.println("Minimum of range " + L + " to " + R + " is " + minimum);
        System.out.println("Maximum of range " + L + " to " + R + " is " + maximum);

        return minimum;
    }
}
