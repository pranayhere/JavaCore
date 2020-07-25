package com.pranay.interview.graph;

import java.util.Arrays;

/**
 * 329. Longest Increasing Path in a Matrix
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInMatrix {
    public static void main(String[] args) {
        int[][] nums = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

//        int[][] nums = {
//                {3, 4, 5},
//                {3, 2, 6},
//                {2, 2, 1}
//        };

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
                //int size = dfsWithCache(nums, r, c, cache);
                int size = dfs(nums, r, c);
                System.out.println("size : " + size + " r : " + r + " c : " + c);
                maxSize = Math.max(size, maxSize);
            }
        }
        for (int[] arr: cache) {
            System.out.println(Arrays.toString(arr));
        }

        return maxSize;
    }

    // dfs with cache dfs + cache
    private static int dfsWithCache(int[][] nums, int r, int c, int[][] cache) {
        if (cache[r][c] != 0) return cache[r][c];

        int m = nums.length;
        int n = nums[0].length;

        for (int[] d : dirs) {
            int x = r + d[0];
            int y = c + d[1];

            if (x < 0 || x >= m || y < 0 || y >= n || nums[x][y] <= nums[r][c]) {
                continue;
            }

            cache[r][c] = Math.max(cache[r][c], dfsWithCache(nums, x, y, cache));
        }
        return ++cache[r][c];
    }

    // dfs
    private static int dfs(int[][] nums, int r, int c) {
        int nr = nums.length;
        int nc = nums[0].length;
        int len = 0;

        for (int[] dir: dirs ) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || nums[newR][newC] <= nums[r][c])
                continue;

            len = Math.max(len, dfs(nums, newR, newC)); // since there can be more than one path starting from the (r, c). 1->2->6->9 and 1->6->8,
            // so we need to choose the path with max length, if not ans returned will be the length of the path that is visited last. i.e. 1->6->8
        }

        return len + 1;
    }
}
