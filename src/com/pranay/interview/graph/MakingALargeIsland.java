package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 827. Making A Large Island
 * https://leetcode.com/problems/making-a-large-island/
 */
public class MakingALargeIsland {
    public static void main(String[] args) {
//        int[][] grid = {
//                {1,1,0},
//                {1,0,1},
//                {1,0,1},
//        };

        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };

        MakingALargeIsland li = new MakingALargeIsland();
        int size = li.largestIsland(grid);
        System.out.println("largest island : " + size);
    }

    Map<String, String> islandMap = new HashMap<>();
    Map<String, Integer> islandSize = new HashMap<>();

    public int largestIsland(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        int count = 0;
        int zeros = 0;
        boolean[][] seen = new boolean[nr][nc];

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 0)
                    zeros++;

                if (grid[r][c] == 1 && !seen[r][c]) {
                    count++;
                    String key = "island-" + count;
                    int size = dfs(grid, r, c, seen, "island-" + count);
                    islandSize.put(key, size);
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int maxSize = 0;

        System.out.println(islandSize);
        System.out.println(islandMap);

        if (islandSize.size() == 1 && zeros > 0) {
            return islandSize.get("island-1") + 1;
        }

        if (zeros == 0)
            return islandSize.get("island-1");

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 0) {
                    Set<String> islands = new HashSet<>();
                    for (int[] d : dirs) {
                        int newR = d[0] + r;
                        int newC = d[1] + c;

                        if (islandMap.containsKey(newR + "-" + newC)) {
                            islands.add(islandMap.get(newR + "-" + newC));
                        }
                    }

                    List<String> islandsList = new ArrayList<>(islands);
                    int size = 0;
                    for (int i = 0; i < islands.size(); i++) {
                        size += islandSize.get(islandsList.get(i));
                    }
                    size++;
                    maxSize = Math.max(size, maxSize);
                }
            }
        }

        return maxSize;
    }

    public int dfs(int[][] grid, int r, int c, boolean[][] seen, String island) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == 0 || seen[r][c]) {
            return 0;
        }

        seen[r][c] = true;

        islandMap.put(r + "-" + c, island);
        int size = 0;
        size = 1 + dfs(grid, r + 1, c, seen, island)
                + dfs(grid, r - 1, c, seen, island)
                + dfs(grid, r, c + 1, seen, island)
                + dfs(grid, r, c - 1, seen, island);

        return size;
    }
}
