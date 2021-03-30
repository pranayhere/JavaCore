package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoMap {
    public static void main(String[] args) {
        int[][] a = {{0, 0, 1},{1, 0, 0}};
        int[][] b = {{0, 0, 1},{1, 0, 0}};;

        IntersectionOfTwoMap istm = new IntersectionOfTwoMap();
        int islands = istm.solve(a, b);
        System.out.println("Islands : " + islands);
    }

    public int solve(int[][] a, int[][] b) {
        Set<List<Integer>> islandPattern1 = new HashSet<>();
        Set<List<Integer>> islandPattern2 = new HashSet<>();

        int nr = a.length;
        int nc = a[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (a[r][c] == 1) {
                    List<Integer> shape = new ArrayList<>();
                    dfs(a, r, c, shape);
                    islandPattern1.add(shape);
                }
            }
        }

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (b[r][c] == 1) {
                    List<Integer> shape = new ArrayList<>();
                    dfs(b, r, c, shape);
                    islandPattern2.add(shape);
                }
            }
        }

        System.out.println(islandPattern1);
        System.out.println(islandPattern2);

        islandPattern1.retainAll(islandPattern2);
        return islandPattern1.size();
    }

    public void dfs(int[][] grid, int r, int c, List<Integer> shape) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] != 1)
            return;

        grid[r][c] = 0;

        shape.add(r * nc + c);
        dfs(grid, r + 1, c, shape);
        dfs(grid, r - 1, c, shape);
        dfs(grid, r, c + 1, shape);
        dfs(grid, r, c - 1, shape);
    }
}
