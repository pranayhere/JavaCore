package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PathWithMaxProbability {
    class Point {
        int end;
        double probability;

        public Point(int end, double probability) {
            this.end = end;
            this.probability = probability;
        }
    }

    public static void main(String[] args) {
        int n = 5;
//        int[][] edges = {{0,1},{1,2},{0,2}};
//        double[] succProb = {0.5,0.5,0.2};
        int[][] edges = {{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
        double[] succProb = {0.37,0.17,0.93,0.23,0.39,0.04};
        int start = 3, end = 4;

        PathWithMaxProbability pmp = new PathWithMaxProbability();
        double ans = pmp.maxProbability(n, edges, succProb, start, end);
        System.out.println("Ans : " + ans);
    }

    // Dijkstra O(E. logV)
    private double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        final Map<Integer, List<Point>> g = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            g.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(new Point(edges[i][1], succProb[i]));
            g.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(new Point(edges[i][0], succProb[i]));
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        pq.offer(new Point(start, 1.0));

        boolean[] seen = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Point curr = pq.poll();
            if (curr.end == end) {
                return curr.probability;
            }

            if (seen[curr.end]) {
                continue;
            }

            seen[curr.end] = true;

            for (Point next : g.get(curr.end)) {
                pq.offer(new Point(next.end, curr.probability * next.probability));
            }
        }

        return 0;
    }

    double maxProb = 0;
    Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
    private  double maxProbabilityInDirectedGraph(int n, int[][] edges, double[] succProb, int start, int end) { // not the right solution
        for (int i = 0; i < edges.length; i++) {
            graph.computeIfAbsent(edges[i][0], k -> new HashMap<>()).put(edges[i][1], succProb[i]);
            graph.computeIfAbsent(edges[1][0], k -> new HashMap<>()).put(edges[i][0], succProb[i]);
        }

        System.out.println(graph);
        dfs(start, end, 1);
        return maxProb;
    }

    private void dfs(int start, int end, double currProb) {
        if (start == end) {
            maxProb = Math.max(currProb, maxProb);
            return;
        }

        if (graph.get(start) == null) {
            return;
        }

        for (int neigh: graph.get(start).keySet()) {
            dfs(neigh, end, currProb * graph.get(start).get(neigh));
        }
    }
}
