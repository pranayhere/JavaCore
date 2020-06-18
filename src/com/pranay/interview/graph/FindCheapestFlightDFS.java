package com.pranay.interview.graph;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCheapestFlightDFS {
    public static void main(String[] args) {
        SimpleDateFormat DateFor = new SimpleDateFormat("yyyyMMdd'T'Hmmss'Z'");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 1000); //here n is no.of year you want to increase
        Date date = cal.getTime();

        System.out.println("Max Date : " + DateFor.format(date));

        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0, dst = 2, k = 1, n = 3;

        FindCheapestFlightDFS cheapestFlight = new FindCheapestFlightDFS();
        int cost = cheapestFlight.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cost);
    }

    int minPathCost;

    private int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        minPathCost = Integer.MAX_VALUE;
        Map<Integer, List<List<Integer>>> graph = createGraph(flights);

        dfs(graph, src, dst, k+1, 0); // k stops = k+1 edges
        return minPathCost == Integer.MAX_VALUE ? -1 : minPathCost;
    }

    private void dfs(Map<Integer, List<List<Integer>>> graph, int src, int dst, int k, int currentCost) {
        if (k < 0)
            return;

        if (src == dst) {
            minPathCost = currentCost;
            return;
        }

        if (!graph.containsKey(src))
            return;

        for (List<Integer> flight: graph.get(src)) {
            if (currentCost + flight.get(1) > minPathCost)
                continue;
            dfs(graph, flight.get(0), dst, k -1, currentCost + flight.get(1));
        }
    }

    private Map<Integer, List<List<Integer>>> createGraph(int[][] flights) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int[] flight: flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(Arrays.asList(flight[1], flight[2]));
        }
        System.out.println("Graph : " + graph);
        return graph;
    }


}
