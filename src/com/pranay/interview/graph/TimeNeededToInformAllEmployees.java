package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        int n = 6;
        int headID = 2;
        int[] manager = {2,2,-1,2,2,2};
        int[] informTime = {0,0,1,0,0,0};

        int mins = numOfMinutes(n, headID, manager, informTime);
        System.out.println("Mins : " + mins);
    }

    private static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int j = manager[i];
            if (!graph.containsKey(j))
                graph.put(j, new ArrayList<>());
            graph.get(j).add(i);
        }

        System.out.println("graph : " + graph);
        return dfs(graph, informTime, headID);
    }

    private static int dfs(Map<Integer, List<Integer>> graph, int[] informTime, int curr) {
        int max = 0;
        if (!graph.containsKey(curr))
            return max;

        for (int next : graph.get(curr)) {
            int currMax = dfs(graph, informTime, next);
            max = Math.max(max, currMax);
        }
        return max + informTime[curr];
    }
}
