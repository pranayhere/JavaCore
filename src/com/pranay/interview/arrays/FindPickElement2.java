package com.pranay.interview.arrays;

import java.util.Arrays;

/**
 * 1901. Find a Peak Element II
 * https://leetcode.com/problems/find-a-peak-element-ii/
 */
public class FindPickElement2 {
    public static void main(String[] args) {
//        int[][] mat = {{1,4},{3,2}};
        int[][] mat = {{10, 20, 15}, {21, 30, 14}, {7, 16, 32}};
        int[] ans = findPeakGrid(mat);
        System.out.println("Ans : " + Arrays.toString(ans));
    }

    public static int[] findPeakGrid(int[][] mat) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int nr = mat.length;
        int nc = mat[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                int base = mat[r][c];
                int di = 0;
                for (di = 0; di < dirs.length; di++) {
                    int[] d = dirs[di];
                    int newR = r + d[0];
                    int newC = c + d[1];

                    int curr = -1;
                    if (!(newR < 0 || newR >= nr || newC < 0 || newC >= nc))
                        curr = mat[newR][newC];

                    System.out.println(curr + " === " + base);
                    if (curr > base)
                        break;
                }

                if (di == 4)
                    return new int[]{r, c};
            }
        }

        return new int[0];
    }
}
