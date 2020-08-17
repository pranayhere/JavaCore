package com.pranay.interview.graph;

public class LongestIncreasingPathInMatrix2 {
    public static void main(String[] args) {
        int[][] nums = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        int size = LongestIncreasingPathInMatrix2.longestIncreasingPath(nums);
        System.out.println("Size of longest increasing path : " + size);
    }

    private static int longestIncreasingPath(int[][] nums) {
        int nr = nums.length;
        int nc = nums[0].length;

        int maxSize = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                int size = dfs(nums, r, c);
                maxSize = Math.max(size, maxSize);
            }
        }
        return maxSize;
    }

    public static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int[][] nums, int r, int c) {
        int nr = nums.length;
        int nc = nums[0].length;

        int len = 0;

        for (int[] dir: dirs) {
            int newR = dir[0] + r;
            int newC = dir[1] + c;

            if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || nums[newR][newC] <= nums[r][c])
                continue;

            len = Math.max(len, dfs(nums, newR, newC));
        }
        return len + 1;
    }
}
