package com.pranay.interview.searching;

/**
 * 1300. Sum of Mutated Array Closest to Target
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 */
public class SumOfArrayClosestToTarget {
    public static void main(String[] args) {
        int[] arr = {4, 9, 3};
        int target = 10;

        int ans = findBestValue(arr, target);
        System.out.println("Ans : " + ans);
    }

    private static int findBestValue(int[] arr, int target) {
        int lo = 0;
        int hi = 0;

        for (int a : arr)
            hi = Math.max(a, hi);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = getSum(arr, mid);

            if (sum == target)
                return mid;
            else if (sum < target)
                lo = lo + 1;
            else
                hi = hi - 1;
        }

        // at this point, the solution is either low or low - 1;
        int first = getSum(arr, lo);
        int second = getSum(arr, lo - 1);

        if (Math.abs(first - target) < Math.abs(second - target))
            return lo;

        return lo - 1;
    }

    private static int getSum(int[] arr, int currTarget) {
        int sum = 0;

        for (int a : arr)
            sum += a > currTarget ? currTarget : a;
        return sum;
    }
}
