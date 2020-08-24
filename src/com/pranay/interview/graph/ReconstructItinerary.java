package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 332. Reconstruct Itinerary
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "SFO"));
        tickets.add(List.of("JFK", "ATL"));
        tickets.add(List.of("SFO", "ATL"));
        tickets.add(List.of("ATL", "JFK"));
        tickets.add(List.of("ATL", "SFO"));

        ReconstructItinerary ri = new ReconstructItinerary();
        List<String> topologicalSort = ri.findItinerary(tickets);
        System.out.println(topologicalSort);
    }

    Map<String, List<String>> flightMap = new HashMap<>();
    private List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();

        for (List<String> ticket: tickets) {
            flightMap.computeIfAbsent(ticket.get(0), k-> new ArrayList<>()).add(ticket.get(1));
        }

        flightMap.forEach((key, value) -> Collections.sort(value));
        System.out.println(flightMap);

        dfs("JFK", res);
        return res;
    }

    private void dfs(String origin, List<String> res) {
        if (flightMap.containsKey(origin)) {
            List<String> dests = flightMap.get(origin);
            while(!dests.isEmpty()) {
                String dest = dests.remove(0);
                dfs(dest, res);
            }
        }
        res.add(0, origin);
    }
}
