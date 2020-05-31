package com.pranay.interview.searching;

public class FirstBadVersion {
    public static void main(String[] args) {
        int n = 5;
        int version = firstBadVersion(5);
        System.out.println("Version : " + version);
    }

    private static boolean isBadVersion(int num) {
        boolean[] version = {false, true, true, true, true};
        return version[num - 1];
    }

    private static int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
