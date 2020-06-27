package com.pranay.interview.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 0;
        int nums = numSquares(n);
        System.out.println("Min nums : " + nums);
    }

    private static int numSquares(int n) {
        if (n == 0)
            return 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i<=n; i++) {
            int square = i * i;
            if (square > n)
                break;
            list.add(square);
        }

        Integer[] nums = list.toArray(new Integer[list.size()]);

        System.out.println(Arrays.toString(nums));
        int[][] T = new int[nums.length + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            T[0][i] = n + 1;
        }

        for (int i = 1; i<T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (j < nums[i - 1])
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = Math.min(T[i-1][j], T[i][j - nums[i-1]] + 1);
            }
        }
        print2d(T);
        return T[T.length - 1][T[0].length - 1];
    }

    private static void print2d(int[][] nums) {
        for (int[] arr: nums) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
