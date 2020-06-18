package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindCheapestFlightBFS {
    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0, dst = 2, k = 1, n = 3;

        FindCheapestFlightBFS cheapestFlight = new FindCheapestFlightBFS();
        int cost = cheapestFlight.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cost);
    }

    private int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int minCostPath = Integer.MAX_VALUE;
        Map<Integer, List<int[]>> graph = createGraph(flights);

        int steps = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {src, 0});

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i<size; i++) {
                int[] currentStop = q.poll();

                if (currentStop[0] == dst)
                    minCostPath = Math.min(minCostPath, currentStop[1]);

                if (!graph.containsKey(currentStop[0]))
                    continue;

                for (int[] flight: graph.get(currentStop[0])) {
                    if (currentStop[1] + flight[1] > minCostPath)
                        continue;
                    q.add(new int[] {flight[0], currentStop[1] + flight[1]});
                }
            }

            if (steps++ > k)
                break;
        }

        return minCostPath == Integer.MAX_VALUE ? -1 : minCostPath;
    }

    private Map<Integer, List<int[]>> createGraph(int[][] flights) {
        Map<Integer, List<int[]>> graph = new HashMap<>(); // direct stops + cost to reach that stop
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return graph;
    }
}
