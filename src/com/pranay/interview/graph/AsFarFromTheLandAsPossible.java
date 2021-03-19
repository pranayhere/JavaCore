package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1162. As Far from Land as Possible
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 */
public class AsFarFromTheLandAsPossible {
    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}}; // ans = 2 The cell (1, 1) is as far as possible from all the land with distance 2.

        AsFarFromTheLandAsPossible af = new AsFarFromTheLandAsPossible();
        int dist = af.maxDistance(grid);
        System.out.println("Max dist : " + dist);
    }

    public int maxDistance(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        int max = Integer.MIN_VALUE;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    grid[r][c] = 0;
                    q.offer(new int[]{r, c});
                } else {
                    grid[r][c] = Integer.MAX_VALUE;
                    cnt++;
                }
            }
        }


        if (q.isEmpty() || cnt == 0) // there is no land || there is no water
            return -1;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {
                int newR = d[0] + r;
                int newC = d[1] + c;

                if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || grid[newR][newC] <= grid[r][c] + 1)
                    continue;

                q.offer(new int[]{newR, newC});
                grid[newR][newC] = grid[r][c] + 1;

                max = Math.max(max, grid[newR][newC]);
            }
        }
        return max;
    }
}
