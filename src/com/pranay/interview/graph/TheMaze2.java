package com.pranay.interview.graph;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 505. The Maze II
 * https://leetcode.com/problems/the-maze-ii/
 */
public class TheMaze2 {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };

        int[] start = {0, 4};
        int[] end = {4, 4};

        int distance = shortestDistance(maze, start, end);
        System.out.println("Distance : " + distance);
    }

    private static int shortestDistance(int[][] maze, int[] start, int[] end) {
        int r = maze.length;
        int c = maze[0].length;
        int res = Integer.MAX_VALUE;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], 0});

        int[][] length = new int[r][c];
        for (int[] a : length) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (length[curr[0]][curr[1]] <= curr[2])
                continue;

            length[curr[0]][curr[1]] = curr[2];

            if (curr[0] == end[0] && curr[1] == end[1])
                res = Math.min(curr[2], res);

            for (int[] dir : dirs) {
                int x = curr[0];
                int y = curr[1];
                int len = curr[2];

                while (x >= 0 && y >= 0 && x < r && y < c && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    len++;
                }

                x -= dir[0];
                y -= dir[1];
                len--;

                q.offer(new int[]{x, y, len});
            }
        }

        return res != Integer.MAX_VALUE ? res : -1;
    }
}