package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TheMeetingPlace {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 0, 1, 0},
                {1, 0, 1, 2},
                {0, 0, 2, 2}
        };

        int dist = findBestMeetingPlace(matrix);
        System.out.println("Min dist travel for all ppl is : " + dist);
    }

    private static int findBestMeetingPlace(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;


        int[][] dp = new int[nr][nc];

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 2) {
                    boolean[][] seen = new boolean[nr][nc];
                    bfs(grid, r, c, dp, seen);
                }
            }
        }

//        System.out.println(Arrays.deepToString(dp));

        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (dp[r][c] == 0)
                    continue;

                ans = Math.min(ans, dp[r][c]);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private static void bfs(int[][] grid, int row, int col, int[][] dp, boolean[][] seen) {
        int nr = grid.length;
        int nc = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col, 0});

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int dist = curr[2];

                if (seen[r][c])
                    continue;

                seen[r][c] = true;

                dp[r][c] += dist;

                for (int[] d: dir) {
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || grid[newR][newC] == 1)
                        continue;

                    q.offer(new int[]{newR, newC, dist + 1});
                }
            }
        }
    }
}
