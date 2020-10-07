package com.pranay.interview.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 785. Is Graph Bipartite?
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        BipartiteGraph bg = new BipartiteGraph();
        boolean ans = bg.isBipartite(graph);
        boolean ans2 = bg.isBipartiteRec(graph);
        System.out.println("Ans : " + ans);
        System.out.println("Ans2 : " + ans2);
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Stack<Integer> stk = new Stack<>();
                stk.push(start);
                color[start] = 1;

                while (!stk.isEmpty()) {
                    int curr = stk.pop();
                    for (int neighbour : graph[curr]) {
                        if (color[neighbour] == -1) {
                            stk.push(neighbour);
                            color[neighbour] = color[curr] ^ 1;
                        } else if (color[neighbour] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    Map<Integer, Integer> color = new HashMap<>();

    public boolean isBipartiteRec(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (!color.containsKey(i) && !dfs(graph, i, 0))
                return false;
        }
        return true;
    }

    public boolean dfs(int[][] graph, int node, int c) {
        if (color.containsKey(node))
            return color.get(node) == c;

        color.put(node, c);
        for (int next: graph[node]) {
            if (!dfs(graph, next, c ^ 1))
                return false;
        }
        return true;
    }

}
