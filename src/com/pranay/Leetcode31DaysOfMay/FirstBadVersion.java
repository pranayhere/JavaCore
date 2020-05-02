package com.pranay.Leetcode31DaysOfMay;

public class FirstBadVersion {
    public static boolean isBadVersion(int n) {
        boolean[] arr = {false, true, true};
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 2;
        int firstBad = firstBadVersion(n);
        System.out.println("First Bad : " + firstBad);
    }

    private static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
