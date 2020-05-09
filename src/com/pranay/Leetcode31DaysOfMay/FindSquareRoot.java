package com.pranay.Leetcode31DaysOfMay;

public class FindSquareRoot {
    public static void main(String[] args) {
        int num = 2147483647;
        boolean ans = isPerfectSquare(num);
        System.out.println("Ans : " +ans);
    }

    private static boolean isPerfectSquare(int num) {
        long lo = 0;
        long hi = num;

        if (num == 0) {
            return false;
        }

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long mul = mid * mid;
            if (mul == num) {
                return true;
            }

            if (mul < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
