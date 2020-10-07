package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int len = shortestPathBinaryMatrix(grid);
        System.out.println("Len : " + len);
    }

    private static int shortestPathBinaryMatrix(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (grid[0][0] == 1)
            return -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        int steps = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (r == nr - 1 && c == nc - 1)
                    return steps + 1;

                for (int[] d: dirs) {
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || grid[newR][newC] > 0) {
                        continue;
                    }

                    grid[newR][newC] = 2;
                    q.offer(new int[]{newR, newC});
                }
            }

            steps++;
        }
        return -1;
    }
}
