package com.pranay.interview.graph;

public class FriendCirclesDFS {
    public static void main(String[] args) {
        int[][] M = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };

        int count = findCircleNumDfs(M);
        System.out.println("Total friend circles : " + count);
    }

    private static int findCircleNumDfs(int[][] M) {
        int count = 0;
        for (int r = 0; r < M.length; r++) {
            for (int c = 0; c < M[0].length; c++) {
                if (M[r][c] == 1) {
                    count++;
                    dfs(M, r, c);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] m, int r, int c) {
        int nr = m.length;
        int nc = m[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || m[r][c] == 0) {
            return;
        }

        m[r][c] = 0;
        dfs(m, r + 1, c);
        dfs(m, r - 1, c);
        dfs(m, r, c + 1);
        dfs(m, r, c - 1);
    }



}
