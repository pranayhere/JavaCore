package com.pranay.interview.graph;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {
	public static void main(String[] args) {
		int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
		int minutes = orangesRotting(grid);
        System.out.println("Minutes : " + minutes);
	}

    private static int orangesRotting(int[][] grid) {
        Queue<Map.Entry<Integer, Integer>> q = new ArrayDeque<>();
        int freshOranges = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 2)
                    q.offer(new AbstractMap.SimpleEntry<>(r, c));
                else if (grid[r][c] == 1)
                    freshOranges++;
            }
        }

        int minutesElapsed = -1;
        int[][] directions = {{-1, 0},{1, 0},{0, -1},{0, 1}};

        while (!q.isEmpty()) {
            int size = q.size();
            minutesElapsed++;
            for (int i = 0; i<size; i++) {
                Map.Entry<Integer, Integer> p = q.poll();
                int r = p.getKey();
                int c = p.getValue();

                for (int[] d: directions) {
                    int newR = r + d[0];
                    int newC = c + d[1];

                    if (newR < 0 || newR >= nr || newC < 0 || newC >= nc) {
                        continue;
                    }

                    if (grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        q.offer(new AbstractMap.SimpleEntry<>(newR, newC));
                        freshOranges--;
                    }
                }
            }
        }
	    return freshOranges == 0 ? minutesElapsed : -1;
    }
}
