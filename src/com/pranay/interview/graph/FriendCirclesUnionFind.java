package com.pranay.interview.graph;

import java.util.Arrays;

public class FriendCirclesUnionFind {
    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int count = findCircleNumUnionFind(M);
        System.out.println("Total friend circles : " + count);
    }

    private static int findCircleNumUnionFind(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);

        for (int i = 0; i<M.length; i++) {
            for (int j = 0; j<M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    private static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }

    private static int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
}
