package com.pranay.interview.graph;

import java.util.*;

/**
 * There are n cities connected by some number of flights. You are given an array flights
 * where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * <p>
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 * <p>
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 * <p>
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
 * <p>
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph is shown above.
 * The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 * <p>
 * Constraints:
 * 2 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * There will not be any multiple flights between two cities.
 * 0 <= src, dst, k < n
 * src != dst
 */

public class CheapestFlight {
    public static void main(String[] args) {
        int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 1;

        CheapestFlight cf = new CheapestFlight();
        int cost = cf.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Ans: " + cost);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int s = flight[0];
            int d = flight[1];
            int cost = flight[2];

            graph.computeIfAbsent(s, x -> new ArrayList<>()).add(new int[]{d, cost});
        }

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});

        // min stops used to reach city
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int city = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (city == dst) {
                return cost;
            }

            if (stops > k || cost >= best[city]) {
                continue;
            }

            best[city] = cost;

            for (int[] next : graph.getOrDefault(city, new ArrayList<>())) {
                pq.offer(new int[]{next[0], cost + next[1], stops + 1});
            }
        }

        return -1;
    }
}
