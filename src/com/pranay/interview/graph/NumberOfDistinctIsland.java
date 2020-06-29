package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIsland {
    public static void main(String[] args) {
//        int[][] grid = {
//                {1,1,0,0,0},
//                {1,1,0,0,0},
//                {0,0,0,1,1},
//                {0,0,0,1,1}
//        };

        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        };
        NumberOfDistinctIsland di = new NumberOfDistinctIsland();
        int distinctIslands = di.findDistinctIsland(grid);
        System.out.println("Distinct islands : " + distinctIslands);
    }

    List<Integer> shape = new ArrayList<>();
    private int findDistinctIsland(int[][] grid) {
        Set<List<Integer>> islandPattern = new HashSet<>();
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c, 0);
                    islandPattern.add(new ArrayList<>(shape));
                    System.out.println("shape : " + shape);
                    shape.clear();
                }
            }
        }
        System.out.println(islandPattern);
        return islandPattern.size();
    }

    private void dfs(int[][] grid, int r, int c, int di) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == 0) {
            return;
        }

        shape.add(di);
        grid[r][c] = 0;
        dfs(grid, r + 1, c, 1);
        dfs(grid, r - 1, c, 2);
        dfs(grid, r, c + 1, 3);
        dfs(grid, r, c - 1, 4);
        shape.add(0);
    }
}
