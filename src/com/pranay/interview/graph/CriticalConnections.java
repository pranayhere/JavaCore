package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 * https://www.youtube.com/watch?v=RYaakWv5m6o&list=LLUJfISFvZf7XWWyaNQ4IBsg&index=2&t=0s - Explaination
 *
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections
 * forming a network where connections[i] = [a, b] represents a connection between servers a and b.
 * Any server can reach any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 * Example 1:
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 */

public class CriticalConnections {
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
        int[] low = new int[n];
//        for (int i = 0; i < n; i++) {
//            low[i] = i;
//        }
        System.out.println(Arrays.toString(low));

        boolean[] visited = new boolean[n];
        int prevNode = -1, currNode = 0, currlow = 0;
        dfs(visited, low, prevNode, currNode, currlow);
        return res;
    }

    private void dfs(boolean[] visited, int[] low, int prevNode, int currNode, int currlow) {
        low[currNode] = currlow;
        visited[currNode] = true;

        for (int next: graph.get(currNode)) {
            if (next == prevNode)
                continue;
            if (!visited[next])
                dfs(visited, low, currNode, next, currlow + 1);
            low[currNode] = Math.min(low[currNode], low[next]);
            if (low[next] == currlow + 1) {
                res.add(Arrays.asList(currNode, next));
            }
        }
    }
}
