package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class TheMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4};
        int[] dest = {4,4};

        int ans = hasPath(maze, start, dest);
        System.out.println("Has Path ? " + ans);
    }

    private static int hasPath(int[][] maze, int[] start, int[] dest) {
        int nr = maze.length;
        int nc = maze[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1]});

        boolean[][] seen = new boolean[nr][nc];
        seen[start[0]][start[1]] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int n = 0; n < size; n++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (r == dest[0] && c == dest[1])
                    return steps;

                for (int[] dir: dirs) {
                    int newR = dir[0] + r;
                    int newC = dir[1] + c;

                    if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || seen[newR][newC] || maze[newR][newC] == 1)
                        continue;

                    seen[newR][newC] = true;
                    q.offer(new int[] {newR, newC});
                }
            }
            steps++;
        }
        return -1;
    }
}

/*
[0,0,1,0,0],
[0,0,0,0,0],
[0,0,0,1,0],
[1,1,0,1,1],
[0,0,0,0,0]

[0,4]
[3,2]
 */