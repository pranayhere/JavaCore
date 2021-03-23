package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponentsInUndirectedGraph {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{3,4}};

        ConnectedComponentsInUndirectedGraph ccud = new ConnectedComponentsInUndirectedGraph();
        int count = ccud.countComponents(n, edges);
        System.out.println("Ans : " + count);
    }

    Map<Integer, List<Integer>> graph = new HashMap<>(); // node, parent
    Map<Integer, Integer> color = new HashMap<>();

    public int countComponents(int q, int[][] edges) {
        for (int[] e: edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(e[0]);
        }

        List<Integer> nodes = new ArrayList<>();
        for (int i = 0; i < q; i++)
            nodes.add(i);

        Set<Integer> seen = new HashSet<>();

        for (Integer n: nodes) {
            if (!seen.contains(n))
                dfs(n, n, seen);
        }

        Set<Integer> ans = new HashSet<>(color.values());

        System.out.println(color);
        return ans.size();
    }

    public void dfs(int node, int parent, Set<Integer> seen) {
        if (seen.contains(node))
            return;

        color.put(node, parent);
        seen.add(node);

        for (int neigh: graph.getOrDefault(node, new ArrayList<>())) {
            dfs(neigh, parent, seen);
        }
    }

    // union find

//    class Solution {
//        public int countComponents(int n, int[][] edges) {
//            UnionFind uf = new UnionFind(n);
//            for (int[] edge : edges) {
//                uf.union(edge[0], edge[1]);
//            }
//            return uf.count;
//        }
//    }
//
//    class UnionFind {
//
//        int count;
//        int[] id;
//
//        public UnionFind(int n) {
//            this.count = n;
//            this.id = new int[n];
//            for (int i = 0; i < n; i++) {
//                id[i] = i;
//            }
//        }
//
//        private int root(int i) {
//            while (i != id[i]) {
//                // magic line, flat the tree
//                id[i] = id[id[i]];
//                i = id[i];
//            }
//            return i;
//        }
//
//        public void union(int p, int q) {
//            int i = root(p), j = root(q);
//            if (i == j) return;
//            id[i] = j;
//            count--;
//        }
//    }
}
