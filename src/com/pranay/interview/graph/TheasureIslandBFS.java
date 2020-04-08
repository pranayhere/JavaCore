package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int r, c;
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class TheasureIslandBFS {

	public static void main(String[] args) {
		char[][] grid ={
				{'O', 'O', 'O', 'O'},
				{'D', 'O', 'D', 'O'},
				{'O', 'O', 'O', 'O'},
				{'X', 'D', 'D', 'O'}
		};
		int minSteps = theasureIslandBFS(grid);
		System.out.println("Min steps : " + minSteps);
		int minSteps2 = theasureIslandDFS(grid);
		System.out.println("Min Steps : " + minSteps2);
	}

	private static int distance = Integer.MAX_VALUE;

	private static int theasureIslandDFS(char[][] island) {
		if (island == null)
			return 0;

		boolean[][] visited = new boolean[island.length][island[0].length];
		dfs(island, 0, 0, visited, 0);

		return distance;
	}

	private static void dfs(char[][] island, int r, int c, boolean[][] visited, int dist) {
		int nr = island.length;
		int nc = island[0].length;

		if (r < 0 || r >= nr || c < 0 || c >= nc || island[r][c] == 'D' || visited[r][c]) {
			return;
		}

		if (island[r][c] == 'X') {
			distance = Math.min(dist, distance);
			return;
		}

		visited[r][c] = true;
		dist++;
		dfs(island, r - 1, c, visited, dist);
		dfs(island, r + 1, c, visited, dist);
		dfs(island, r, c - 1, visited, dist);
		dfs(island, r, c + 1, visited, dist);

		visited[r][c] = false;
	}

	private static int theasureIslandBFS(char[][] island) {
		if (island == null || island.length == 0)
			return 0;

		int steps = 0;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		boolean[][] visited = new boolean[island.length][island[0].length];
		visited[0][0] = true;

		int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i<size; i++) {
				Point p = q.poll();
				int r = p.r;
				int c = p.c;
				if (island[r][c] == 'X')
					return steps;

				for (int[] dir : dirs) {
					int newR = r + dir[0];
					int newC = c + dir[1];

					if (newR < 0 || newR>= island.length || newC<0 || newC >= island[0].length || island[newR][newC] == 'D' || visited[newR][newC]) {
						continue;
					}
					q.add(new Point(newR, newC));
					visited[newR][newC] = true;
				}
			}
			steps++;
		}
		return 0;
	}
}
