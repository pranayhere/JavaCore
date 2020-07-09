package com.pranay.interview.graph;

import java.util.Arrays;

public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
//        int[][] nums = {
//                {9, 9, 4},
//                {6, 6, 8},
//                {2, 1, 1}
//        };

        int[][] nums = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };

        int size = LongestIncreasingPathInMatrix.longestIncreasingPath(nums);
        System.out.println("Size of longest increasing path : " + size);
    }

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int longestIncreasingPath(int[][] nums) {
        int maxSize = 0;
        int nr = nums.length;
        int nc = nums[0].length;

        int[][] cache = new int[nr][nc];

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                int size = dfs(nums, r, c, cache);
                maxSize = Math.max(size, maxSize);
            }
        }
        for (int[] arr: cache) {
            System.out.println(Arrays.toString(arr));
        }

        return maxSize;
    }

    private static int dfs(int[][] nums, int r, int c, int[][] cache) {
        if (cache[r][c] != 0) return cache[r][c];

        int m = nums.length;
        int n = nums[0].length;

        for (int[] d : dirs) {
            int x = r + d[0];
            int y = c + d[1];

            if (x < 0 || x >= m || y < 0 || y >= n || nums[x][y] <= nums[r][c]) {
                continue;
            }

            cache[r][c] = Math.max(cache[r][c], dfs(nums, x, y, cache));
        }
        return ++cache[r][c];
    }
}
