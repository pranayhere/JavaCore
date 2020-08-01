package com.pranay.interview.greedy;

import java.util.Arrays;

/**
 * 135. Candy
 * https://leetcode.com/problems/candy/
 */
public class Candy {
    public static void main(String[] args) {
//        int[] rating = {1, 0, 2};
        int[] rating = {1, 2, 2};
        int candies = candy(rating);
        System.out.println("Candies needed : " + candies);
    }

    private static int candy(int[] rating) {
        int n = rating.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {
            if (rating[i] > rating[i - 1])
                left[i] = 1 + left[i - 1];
        }

        for (int j = n - 2; j >= 0; j--) {
            if (rating[j] > rating[j + 1])
                right[j] = 1 + right[j + 1];
        }

//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
