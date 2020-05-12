package com.pranay.interview.graph;

/**
 * Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search.
 * During DFS, every visited node should be set as '0' to mark as visited node. Count the number of root nodes that trigger DFS,
 * this number would be the number of islands since each DFS starting at some root identifies an island.
 */

public class NumberOfIslandDFS {
	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};

		int count = numIsland2(grid);
		System.out.println("No Of Island : " +count);
	}

	private static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int nr = grid.length;
		int nc = grid[0].length;
		int numIsland = 0;

		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				if (grid[r][c] == '1') {
					numIsland++;
					dfs(grid, r, c);
				}
			}
		}
		return numIsland;
	}

	private static void dfs(char[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;

		if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
			return;
		}

		grid[r][c] = '0';
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);

		// if all moves
		// dfs(grid, r-1, c);
		// dfs(grid, r-1, c-1);
		// dfs(grid, r-1, c+1);
		// dfs(grid, r+1, c);
		// dfs(grid, r+1, c+1);
		// dfs(grid, r+1, c-1);
		// dfs(grid, r, c-1);
		// dfs(grid, r, c+1);
	}

	public static int numIsland2(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int nr = grid.length;
		int nc = grid[0].length;
		int numIsland = 0;

		for (int r = 0; r < nr; r++) {
		    for (int c = 0; c < nc; c++) {
		        if (grid[r][c] == '1') {
		            numIsland ++;
		            dfs2(grid, r, c);
                }
            }
        }
		return numIsland;
	}

	private static void dfs2(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '1';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
	}
}
