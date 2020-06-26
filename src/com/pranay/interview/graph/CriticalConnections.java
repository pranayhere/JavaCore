package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/critical-connections-in-a-network/discuss/671007/CLEAN-JAVA-Tarjan
// https://leetcode.com/problems/critical-connections-in-a-network/discuss/624819/Java-Easy-and-short-Tarjan-implementation
public class CriticalConnections {
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        CriticalConnections cc = new CriticalConnections();
        List<List<Integer>> conn = cc.criticalConnections(n, connections);
        System.out.println(conn);
    }

    Map<Integer, List<Integer>> graph;
    List<List<Integer>> res;

    private List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new HashMap<>();
        res = new LinkedList<>();

        for (List<Integer> conn: connections) {
            int x = conn.get(0);
            int y = conn.get(1);

            graph.computeIfAbsent(x, k -> new LinkedList<>()).add(y);
            graph.computeIfAbsent(y, k -> new LinkedList<>()).add(x);
        }

        System.out.println(graph);
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = i;
        }
        System.out.println(Arrays.toString(rank));

        boolean[] visited = new boolean[n];
        int prevNode = -1, currNode = 0, currRank = 0;
        dfs(visited, rank, prevNode, currNode, currRank);
        return res;
    }

    private void dfs(boolean[] visited, int[] rank, int prevNode, int currNode, int currRank) {
        rank[currNode] = currRank;
        visited[currNode] = true;

        for (int next: graph.get(currNode)) {
            if (next == prevNode)
                continue;
            if (!visited[next])
                dfs(visited, rank, currNode, next, currRank + 1);
            rank[currNode] = Math.min(rank[currNode], rank[next]);
            if (rank[next] == currRank + 1) {
                res.add(Arrays.asList(currNode, next));
            }
        }
    }


}
