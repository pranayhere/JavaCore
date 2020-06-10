package com.pranay.Leetcode30DaysOfJune;

public class PowerOf2 {
    public static void main(String[] args) {
        int n = -16;
        boolean ans = isPowerOfTwo(n);
        System.out.println("Ans : " + ans);
    }

    private static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 0) {
            return false;
        }

        while (n != 1) {
            if (n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }
}
