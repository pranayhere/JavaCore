package com.pranay.interview.arrays;

import java.util.Arrays;

public class PieceOfCake {
    public static void main(String[] args) {
        int h = 5, w = 4;
        int[] horizontalCuts = {1, 2, 4}, verticalCuts = {1, 3};

        int area = maxArea(h, w, horizontalCuts, verticalCuts);
        System.out.println("Area : " + area);
    }

    private static int maxArea(int h, int w, int[] hc, int[] vc) {
        return (int) (getMax(h, hc) * getMax(w, vc)) % 1_000_000_007;
    }

    private static int getMax(int end, int[] cuts) {
        int res = 0, from = 0;
        Arrays.sort(cuts);

        for (int c: cuts) {
            res = Math.max(res, c - from);
            from = c;
        }

        return Math.max(res, end - from);
    }
}
