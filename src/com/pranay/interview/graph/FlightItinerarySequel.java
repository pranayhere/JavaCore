package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Flight Itinerary Sequel
 * https://binarysearch.com/problems/Flight-Itinerary-Sequel
 *
 * 332. Reconstruct Itinerary
 * https://leetcode.com/problems/reconstruct-itinerary/
 *
 * You are given a list of flights that were taken, represented as origin to destination airport pairs.
 * Given that this list was shuffled, find all the airports that were visited in the correct order.
 * If there's more than one valid itinerary, return the lexicographically smallest ones first.
 *
 * Note: airports may be visited twice.
 *
 * flights = [[YYZ, SEA]
 * [JFK, YYZ]
 * [SEA, JFK]]
 *
 * Output
 * ["JFK", "YYZ", "SEA", "JFK"]
 *
 * Input: flights = [QJY, EGM]
 * [EGM, AOI]
 * [AOI, EGM]
 * [HTA, QJY]
 * [EGM, EGM] <--- notice self loop
 *
 * Output:
 * ["HTA", "QJY", "EGM", "AOI", "EGM", "EGM"]
 *
 * Eulerian path, Eulerian circuit or Eulerian cycle
 */
public class FlightItinerarySequel {
    public static void main(String[] args) {
        String flights[][] = {
                {"YYZ", "SEA"},
                {"JFK", "YYZ"},
                {"SEA", "JFK"}};

        FlightItinerarySequel itr = new FlightItinerarySequel();
        String[] sequence = itr.findItinerary(flights);
        System.out.println("ANS : " + Arrays.toString(sequence));
    }

    LinkedList<String> path = new LinkedList<>();

    private String[] findItinerary(String[][] flights) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        Map<String, Integer> degree = new HashMap<>();

        // this map stores outdegree-indegree of a node (used to determine the starting node)
        for (String[] flight: flights) {
            // System.out.println(Arrays.toString(flight));
            map.computeIfAbsent(flight[0], k -> new PriorityQueue<>()).add(flight[1]);
            int from = degree.getOrDefault(flight[0], 0);
            int to = degree.getOrDefault(flight[1], 0);

            degree.put(flight[0], from + 1);
            degree.put(flight[1], to - 1);
        }

        // Determining the starting node, since the problem says that a Eulerian Path/ circuit will
        // exist, we see if there exists a node with outdegree-indegree == 1, if yes then that node
        // will be the starting node.
        String start = "";
        for (String key: degree.keySet()) {
            if (degree.get(key) == 1)
                start = key;
        }

        if (start.equals("")) {
            List<String> tickets = new ArrayList<>(map.keySet());
            Collections.sort(tickets);
            start = tickets.get(0);
        }

        dfs(start, map);
        return path.toArray(new String[0]);
    }

    public void dfs(String start, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> dest = map.getOrDefault(start, new PriorityQueue<>());

        while (!dest.isEmpty()) {
            dfs(dest.poll(), map);
        }

        path.addFirst(start);
    }
}
