package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class HighestPeak {
    public static void main(String[] args) {
        int[][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        int[][] ans = highestPeak(isWater);
        System.out.println(Arrays.deepToString(ans));
    }

    private static int[][] highestPeak(int[][] g) {
        int nr = g.length;
        int nc = g[0].length;

        int[][] res = new int[nr][nc];

        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                res[r][c] = -1;
                if (g[r][c] == 1) {
                    q.offer(new int[]{r, c, 0});
                    res[r][c] = 0;
                }
            }
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];

            for (int[] dir: dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || res[newR][newC] >= 0) {
                    continue;
                }

                res[newR][newC] = cost + 1;
                q.offer(new int[]{newR, newC, cost + 1});
            }
        }

        return res;
    }
}
