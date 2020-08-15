package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.List;

public class CherryPickup {
    public static void main(String[] args) {
//        int[][] grid = {
//                {0, 1, -1},
//                {1, 0, -1},
//                {1, 1, 1}
//        };

//        int[][] grid = {
//                {1, 1, -1},
//                {1, -1, 1},
//                {-1, 1, 1}
//        };

        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1}
        };

        CherryPickup cp = new CherryPickup();
        int totalCherries = cp.cherryPickup(grid);
        System.out.println("Total Cherries : " + totalCherries);
    }

    int[][] grid;
    List<int[]> path;

    int maxCount = 0;

    private int cherryPickup(int[][] grid) {
        this.grid = grid;

        int nr = grid.length;
        int nc = grid[0].length;

        boolean[][] visited = new boolean[nr][nc];
        dfs(0, 0, new ArrayList<>(), visited, 0, 0);

        if (path == null || path.isEmpty())
            return 0;

        int[] last = path.get(path.size() - 1);
        if (last[0] != nr - 1 && last[1] != nc - 1)
            return 0;

        for (int[] arr : path) {
            int r = arr[0];
            int c = arr[1];
            System.out.println(r + " - " + c);
            grid[r][c] = 0;
        }

        System.out.println("==================");
        visited = new boolean[nr][nc];
        int maxCherriesDownward = maxCount;
        maxCount = 0;
        path.clear();

        dfs(nr - 1, nc - 1, new ArrayList<>(), visited, 0, 1);
        if (path == null || path.isEmpty())
            return 0;

        last = path.get(path.size() - 1);
        if (last[0] != 0 && last[1] != 0)
            return 0;

        for (int[] arr : path) {
            int r = arr[0];
            int c = arr[1];
            System.out.println(r + " - " + c);
            grid[r][c] = 0;
        }

        return maxCount + maxCherriesDownward;
    }

    public void dfs(int r, int c, List<int[]> curr, boolean[][] visited, int count, int dir) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == -1 || visited[r][c])
            return;

        visited[r][c] = true;
        curr.add(new int[]{r, c});

        if (grid[r][c] == 1)
            count++;

        if (count > maxCount) {
            if (dir == 0 && r == nr - 1 && c == nc - 1) {
                path = new ArrayList<>(curr);
            } else if (dir == 1 && r == 0 && c == 0) {
                path = new ArrayList<>(curr);
            }
            maxCount = count;
        }

        if (dir == 0) {
            dfs(r + 1, c, curr, visited, count, dir);
            dfs(r, c + 1, curr, visited, count, dir);
        } else {
            dfs(r - 1, c, curr, visited, count, dir);
            dfs(r, c - 1, curr, visited, count, dir);
        }
    }
}
