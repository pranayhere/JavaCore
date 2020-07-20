package com.pranay.interview.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1074. Number of Submatrices That Sum to Target
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 */
public class SubmatricesSumToTarget {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        int target = 0;

        int count = numSubmatrixSumTarget(matrix, target);
        System.out.println("\ncount : " + count);
    }

    private static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] ps = new int[r + 1][c + 1]; // 2d prefix sum

        for (int i = 1; i < ps.length; i++) {
            for (int j = 1; j < ps[0].length; j++) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        System.out.println("Given Input :");
        print2D(matrix);

        System.out.println("\nPrefix sum :");
        print2D(ps);

        int count = 0;
        int sum;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int r1 = 1; r1 < ps.length; r1++) {
            for (int r2 = r1; r2 < ps.length; r2++) {
                hm.clear();
                hm.put(0, 1);

                for (int col = 1; col < ps[0].length; col++) {
                    sum = ps[r2][col] - ps[r1 - 1][col];
                    count += hm.getOrDefault(sum - target, 0);
                    hm.put(sum, hm.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }

    public static void print2D(int[][] arr) {
        for (int[] a: arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
