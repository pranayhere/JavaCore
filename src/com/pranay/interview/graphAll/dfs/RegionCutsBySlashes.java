package com.pranay.interview.graphAll.dfs;

import java.util.Arrays;

/**
 * 959. Regions Cut By Slashes
 * https://leetcode.com/problems/regions-cut-by-slashes/
 *
 * Intuition upscale the given matrix. 3 * 3  is a good choice. this reduces problem to number of islands
 */
public class RegionCutsBySlashes {
    public static void main(String[] args) {
        String[] grid = {"/\\", "\\/"};
        int islands = regionsBySlashes(grid);
        System.out.println("Number of regions : " + islands);
    }

    private static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] map = new int[3 * n][3 * n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r].charAt(c) == '/')
                    map[3 * r + 2][3 * c] = map[3 * r + 1][3 * c + 1] = map[3 * r][3 * c + 2] = 1;

                if (grid[r].charAt(c) == '\\')
                    map[3 * r][3 * c] = map[3 * r + 1][3 * c + 1] = map[3 * r + 2][3 * c + 2] = 1;
            }
        }

        for (int[] m: map) {
            System.out.println(Arrays.toString(m));
        }

        int nr = map.length;
        int nc = map[0].length;

        int islands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (map[r][c] == 0) {
                    islands++;
                    dfs(map, r, c);
                }
            }
        }
        return islands;
    }

    public static void dfs(int[][] map, int r, int c) {
        int nr = map.length;
        int nc = map[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || map[r][c] != 0)
            return;

        map[r][c] = 2;
        dfs(map, r + 1, c);
        dfs(map, r - 1, c);
        dfs(map, r, c + 1);
        dfs(map, r, c - 1);
    }
}
