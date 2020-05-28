package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PossibleBipartition {
    ArrayList<Integer>[] graph;
    Map<Integer, Integer> color;

    public static void main(String[] args) {
        int N = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        PossibleBipartition pb = new PossibleBipartition();
        boolean ans = pb.possibleBipartition(N, dislikes);
        System.out.println("Ans : " + ans);
    }

    private boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList();

        for (int[] edge: dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for (int i = 1; i<= N; i++) {
            System.out.println(graph[i]);
        }

        color = new HashMap();
        for (int node = 1; node <= N; ++node) {
            System.out.println("color : " + color);
            if (!color.containsKey(node) && !dfs(node, 0))
                return false;
        }
        return true;
    }

    private boolean dfs(int node, int c) {
        if (color.containsKey(node))
            return color.get(node) == c;
        color.put(node, c);

        for (int nei : graph[node])
            if (!dfs(nei, c ^ 1))
                return false;
        return true;
    }
}
