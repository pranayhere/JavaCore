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

//        int size = LongestIncreasingPathInMatrix.longestIncreasingPath(nums);

        LongestIncreasingPathInMatrix lpm = new LongestIncreasingPathInMatrix();
        int size = lpm.longestIncreasingPath2(nums);
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
            // so we need to choose the path with max length, if not, ans returned will be the length of the path that is visited last. i.e. 1->6->8
        }

        return len + 1;
    }


    int ans = Integer.MIN_VALUE;
    public int longestIncreasingPath2(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                boolean[][] seen = new boolean[nr][nc];
                dfs(matrix, r, c, 0, -1, seen);
            }
        }

        return ans;
    }

    public void dfs(int[][] grid, int r, int c, int cnt, int prev, boolean[][] seen) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] <= prev || seen[r][c])
            return;

        seen[r][c] = true;
        cnt += 1;

        if (cnt > ans)
            ans = cnt;

        dfs(grid, r + 1, c, cnt, grid[r][c], seen);
        dfs(grid, r - 1, c, cnt, grid[r][c], seen);
        dfs(grid, r, c + 1, cnt, grid[r][c], seen);
        dfs(grid, r, c - 1, cnt, grid[r][c], seen);
    }
    
}
