package com.pranay.interview.searching;

//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

public class MinimumDaysToMakeBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        int days = minDays(bloomDay, m, k);
        System.out.println("Min Days : " + days);
    }

    private static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n)
            return -1;
        int l = 1, h = (int) 1e9;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (check(bloomDay, m, k, mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean check(int[] bloomDay, int m, int k, int day) {
        int count = 0, curr = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                curr++;
                if (curr == k) {
                    count++;
                    curr = 0;
                }
            } else curr = 0;
        }
        return count >= m;
    }
}
