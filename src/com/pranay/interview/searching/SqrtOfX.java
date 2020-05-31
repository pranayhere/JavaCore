package com.pranay.interview.searching;

public class SqrtOfX {
    public static void main(String[] args) {
        int x = 2147395599;
        int sqrt = mySqrt(x);
        System.out.println("Sqrt : " + sqrt);
    }

    private static int mySqrt(int x) {
        if (x < 2) return x;
        int lo = 0, hi = x/2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long mul = (long) mid * mid;
            if (mul == x) {
                return mid;
            } else if (mul > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
