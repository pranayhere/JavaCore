package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class KnightMoves {
    public static void main(String[] args) {
        int nr = 6;
        int nc = 6;

        int[] start = {4, 5};
        int[] target = {1, 1};

        int ans = noOfSteps(nr, nc, start, target);
        System.out.println(ans);
    }
//
//    {4, 5}
//    {6, 4},{6, 6}, {4, 6}, {5, 3}, {2, 4}, {}
//
    public static int noOfSteps(int nr, int nc, int[] start, int[] target) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        int[][] dirs = {{2, -1}, {2, 1}, {1, 2}, {1, -2}, {-2, -1}, {-2, 1}, {-1, -2}, {1, -2}};

        boolean[][] seen = new boolean[nr][nc];
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (r == target[0] && c == target[1]) {
                    return steps; // found the target
                }

                if (seen[r][c])
                    continue;

                seen[r][c] = true;

                for (int[] d: dirs) {
                    int newR = d[0] + r;
                    int newC = d[1] + c;

                    if (newR < 0 || newR >= nr || newC < 0 || newC >= nc)
                        continue;

                    q.offer(new int[]{newR, newC});
                }
            }

            steps++;
        }

        return -1; // not found
    }
}
