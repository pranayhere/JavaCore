package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 934. Shortest Bridge
 * https://leetcode.com/problems/shortest-bridge/
 */
public class ShortestBridge {
    public static void main(String[] args) {
        int[][] A = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };
//        int[][] A = {
//                {0, 1, 0},
//                {0, 0, 0},
//                {0, 0, 1}
//        };

        ShortestBridge sb = new ShortestBridge();
        int len = sb.shortestBridge(A);
        System.out.println("Len : " + len);
    }

    boolean[][] seen;
    private int shortestBridge(int[][] A) {
        int nr = A.length;
        int nc = A[0].length;

        boolean found = false;
        seen = new boolean[nr][nc];
        Queue<int[]> q = new ArrayDeque<>();

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // 1. dfs to find an island, mark it in `visited`
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (found)
                    break;
                else if (A[r][c] == 1) {
                    found = true;
                    dfs(A, r, c, q);
                    break;
                }
            }
        }

        // 2. bfs to expand this island
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d: dirs) {
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || seen[newR][newC])
                        continue;

                    if (A[newR][newC] == 1)
                        return steps;

                    q.offer(new int[]{newR, newC});
                    seen[newR][newC] = true;
                }
            }

            steps++;
        }
        return -1;
    }

    private void dfs(int[][] A, int r, int c, Queue<int[]> q) {
        int nr = A.length;
        int nc = A[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || seen[r][c] || A[r][c] == 0)
            return;

        seen[r][c] = true;
        q.offer(new int[]{r, c});
        dfs(A, r + 1, c, q);
        dfs(A, r - 1, c, q);
        dfs(A, r, c + 1, q);
        dfs(A, r, c - 1, q);
    }


}
