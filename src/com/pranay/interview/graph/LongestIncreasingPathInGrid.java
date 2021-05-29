package com.pranay.interview.graph;

public class LongestIncreasingPathInGrid {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {0, 4, 6},
                {2, 2, 9}
        };

        int len = longestPath(matrix);
        System.out.println("Len : " + len);
    }

    private static int longestPath(int[][] A) {
        int nr = A.length;
        int nc = A[0].length;

        int maxLen = 0;
        int[][] cache = new int[nr][nc];

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                int len = dfs(A, r, c, cache);
                maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;
    }

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int dfs(int[][] A, int r, int c, int[][] cache) {
        if (cache[r][c] != 0)
            return cache[r][c];

        int nr = A.length;
        int nc = A[0].length;

        int len = 0;
        for (int[] d: dirs) {
            int newR = d[0] + r;
            int newC = d[1] + c;

            if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || A[newR][newC] <= A[r][c])
                continue;

            len = Math.max(len, dfs(A, newR, newC, cache));
        }

        return cache[r][c] = len + 1;
    }
}
