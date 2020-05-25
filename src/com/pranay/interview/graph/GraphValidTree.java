package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {
    private List<List<Integer>> adjacencyList = new ArrayList<>();
    private List<Integer> seen = new ArrayList<>();

    private boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        dfs(0);

        return seen.size() == n;
    }

    private void dfs(int node) {
        if (seen.contains(node)) {
            return;
        }
        seen.add(node);
        for (int neighbour: adjacencyList.get(node)) {
            dfs(neighbour);
        }
    }

    public static void main(String[] args) {
        int n = 5;
//        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
//        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        int[][] edges = {{0,1}, {2,3}};
        GraphValidTree graph = new GraphValidTree();
        boolean isValid = graph.validTree(n, edges);
        System.out.println("Is Valid : " + isValid);
    }
}
