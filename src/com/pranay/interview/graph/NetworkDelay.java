package com.pranay.interview.graph;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// Dijkstra
public class NetworkDelay {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4, K = 2;

        int totalTime = networkDelayTimeBellmanFord(times, N, K);
        System.out.println("Total Time : " + totalTime);
    }


    // BFS and Dijkstra  Time complexity: O(Nlog(N) + E), Space complexity: O(N + E)
    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();

        for (int[] time: times) {
            hm.computeIfAbsent(time[0], k -> new HashMap<>()).put(time[1], time[2]);
        }

        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); //  important to use PQ, minHeap based on min distance
        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N + 1];
        int res = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int currNode = curr[1];
            int currDist = curr[0];

            if (visited[currNode])
                continue;

            visited[currNode] = true;
            res = currDist;
            N--;

            if (hm.containsKey(currNode)) {
                for (int next : hm.get(currNode).keySet()) {
                    pq.add(new int[]{currDist + hm.get(currNode).get(next), next});
                }
            }

        }
        return N == 0 ? res : -1;
    }


    // Bellman ford: Time complexity (N * E) = N^2
    public static int networkDelayTimeBellmanFord(int[][] times, int N, int K) {
        double[] distTo = new double[N];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);

        distTo[K - 1] = 0;

        for (int i = 1; i < N; i++) {
            for (int[] edge: times) {
                int u = edge[0] - 1;
                int v = edge[1] - 1;
                int w = edge[2];

                distTo[v] = Math.min(distTo[v] + w, distTo[v]);
            }
        }

        double res = Double.MIN_VALUE;
        for (double i: distTo) {
            res = Math.max(i, res);
        }
        return res == Double.POSITIVE_INFINITY ? -1 : (int) res;
    }
}
