package com.pranay.interview.graph;

import java.util.Arrays;

public class RedundantConnectionUnionFind {
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        RedundantConnectionUnionFind rc = new RedundantConnectionUnionFind();
        int[] edge = rc.findRedundantConnection(edges);
        System.out.println("Redundant edge : " + Arrays.toString(edge));
    }

    private int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i< edges.length; i++) {
            boolean result = union(parent, edges[i][0], edges[i][1]);
            if (result) {
                return new int[] {edges[i][0], edges[i][1]};
            }
        }
        return new int[] {0, 0};
    }

    private boolean union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);

        if (xset != yset) {
            parent[xset] = yset;
            return false;
        } else {
            return true;
        }
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
}
