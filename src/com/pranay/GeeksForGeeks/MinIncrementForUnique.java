package com.pranay.GeeksForGeeks;

// https://leetcode.com/problems/minimum-increment-to-make-array-unique/

import java.util.Arrays;

public class MinIncrementForUnique {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 2, 1, 7};
        int min = minIncrementForUnique(A);
        System.out.println(min);
    }

    private static int minIncrementForUnique(int[] A) {
        int[] count = new int[10];
        for (int i : A)
            count[i]++;

//        System.out.println(Arrays.toString(count));
        int extra = 0, sum = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                extra += count[i] - 1;
                sum -= i * (count[i] - 1);
            } else if (extra > 0 && count[i] == 0) {
                extra--;
                sum += i;
            }
        }
        return sum;
    }
}
