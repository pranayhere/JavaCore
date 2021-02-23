package com.pranay.interview.arrays;

import java.util.Arrays;

public class MinimumOperationsToMoveAllBallstoEachBox {
    public static void main(String[] args) {
        String boxes = "110";
        int[] ops = minOperations(boxes);
        System.out.println("Min Ops : " + Arrays.toString(ops));
    }

    private static int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];

        int count = boxes.charAt(0) - '0';
        for(int i = 1 ; i < n ; i++){
            left[i] = left[i - 1] + count;
            count += boxes.charAt(i) - '0';
        }

        count = boxes.charAt(n - 1) - '0';
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count += boxes.charAt(i) - '0';
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < ans.length; i++) {
            ans[i] = left[i] + right[i];
        }

        return ans;
    }
}