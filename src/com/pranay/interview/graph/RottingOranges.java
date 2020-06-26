package com.pranay.interview.graph;

// https://leetcode.com/problems/rotting-oranges/

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
	public static void main(String[] args) {
		int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//		int minutes = orangesRotting(grid);
		int minutes2 = orangesRotting2(grid);
//		System.out.println("Minutes : " + minutes);
        System.out.println("Minutes2 : " + minutes2);
	}

    private static int orangesRotting2(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        int freshOranges = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 2)
                    q.offer(new Pair<>(r, c));
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
                Pair<Integer, Integer> p = q.poll();
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
                        q.offer(new Pair<>(newR, newC));
                        freshOranges--;
                    }
                }
            }
        }
	    return freshOranges == 0 ? minutesElapsed : -1;
    }

    private static int orangesRotting(int[][] grid) {
		Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
		int freshOranges = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == 2) {
					q.offer(new Pair<>(r, c));
				} else if (grid[r][c] == 1) {
					freshOranges++;
				}
			}
		}

		int minutesElapsed = -1;
		int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		q.offer(new Pair<>(-1, -1));

		while (!q.isEmpty()) {
			Pair<Integer, Integer> p = q.poll();
			int r = p.getKey();
			int c = p.getValue();

			if (r == -1) {
				minutesElapsed++;

				if (!q.isEmpty()) {
					q.offer(new Pair<>(-1, -1));
				}
			} else {
				for (int[] d : directions) {
					int nR = r + d[0];
					int nC = c + d[0];

					if (nR >= 0 && nR < rows && nC >= 0 && nC < cols) {
						if (grid[nR][nC] == 1) {
							grid[nR][nC] = 2;
							freshOranges--;

							q.offer(new Pair<>(nR, nC));
						}
					}
				}
			}
		}

		return freshOranges == 0 ? minutesElapsed : -1;
	}
}
