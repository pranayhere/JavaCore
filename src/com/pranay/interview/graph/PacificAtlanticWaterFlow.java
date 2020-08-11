package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 417. Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/767684/Standard-Java-Solution
 * https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/767518/Java-DFS-4ms
 *
 * The basic idea is that we need to start from the edges and explore to see if our neighbors are fulfill our exploration criteria.
 */
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        PacificAtlanticWaterFlow wf = new PacificAtlanticWaterFlow();
        List<List<Integer>> ans = wf.pacificAtlantic(A);
        System.out.println("Ans : " + ans);
    }

    private List<List<Integer>> pacificAtlantic(int[][] A) {
        List<List<Integer>> res = new ArrayList<>();

        if (A == null || A.length == 0)
            return res;

        int nr = A.length;
        int nc = A[0].length;

        boolean[][] pacific = new boolean[nr][nc];
        boolean[][] atlantic = new boolean[nr][nc];

        for (int c = 0; c < nc; c++) {
            dfs(A, pacific, 0, c, A[0][c]);
            dfs(A, atlantic, nr - 1, c, A[nr - 1][c]);
        }
        for (int r = 0; r < nr; r++) {
            dfs(A, pacific, r, 0, A[r][0]);
            dfs(A, atlantic, r, nc - 1, A[r][nc - 1]);
        }

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (pacific[r][c] && atlantic[r][c])
                    res.add(new ArrayList<>(Arrays.asList(r, c)));
            }
        }
        return res;
    }

    public void dfs(int[][] A, boolean[][] flow, int r, int c, int height) {
        int nr = A.length;
        int nc = A[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || flow[r][c] || A[r][c] < height)
            return;

        flow[r][c] = true;

        dfs(A, flow, r + 1, c, A[r][c]);
        dfs(A, flow, r - 1, c, A[r][c]);
        dfs(A, flow, r, c + 1, A[r][c]);
        dfs(A, flow, r, c - 1, A[r][c]);
    }
}
