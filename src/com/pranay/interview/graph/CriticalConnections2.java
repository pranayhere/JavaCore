package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CriticalConnections2 {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        connections.add(Arrays.asList(3, 4));
        connections.add(Arrays.asList(4, 5));
        connections.add(Arrays.asList(5, 3));

        CriticalConnections2 cc = new CriticalConnections2();
        List<List<Integer>> conn = cc.criticalConnections(n, connections);
        System.out.println(conn);
    }

    int[] disc; // discovery
    int[] low;  // low
    List<List<Integer>> ans = new LinkedList<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc = new int[connections.size()];
        low = new int[connections.size()];

        for (List<Integer> conn : connections) { // build adjacency map
            int x = conn.get(0);
            int y = conn.get(1);

            graph.computeIfAbsent(x, k -> new LinkedList<>()).add(y);
            graph.computeIfAbsent(y, k -> new LinkedList<>()).add(x);
        }
        dfs(0, -1, 1);
        return ans;
    }

    private void dfs(int node, int parent, int time) {
        disc[node] = low[node] = time;
        for (Integer n : graph.get(node)) {
            if (n == parent) continue; // skip parent node from which we came
            if (disc[n] == 0) { // unvisited
                dfs(n, node, ++time);
            }
            // node -> n is visited at this point, so update low
            low[node] = Math.min(low[node], low[n]);
            if (low[node] < low[n]) { // neighbour is visited after the current node (no earlier path found)
                ans.add(List.of(node, n));
            }
        }
    }
}
