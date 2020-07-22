package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1376. Time Needed to Inform All Employees
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/submissions/
 */
public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
        int n = 6;
        int headID = 2;
        int[] manager = {2,2,-1,2,2,2};
        int[] informTime = {0,0,1,0,0,0};

        TimeNeededToInformAllEmployees t = new TimeNeededToInformAllEmployees();
        int mins = t.numOfMinutes(n, headID, manager, informTime);
        System.out.println("Mins : " + mins);
    }

    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] time;

    private int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        time = informTime;
        for (int i = 0; i < manager.length; i++)
            g.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);

        return dfs(headId);
    }

    private int dfs(int curr) {
        int max = 0;
        if (!g.containsKey(curr))
            return max;

        for (int next : g.get(curr)) {
            int currMax = dfs(next);
            max = Math.max(max, currMax);
        }
        return max + time[curr];
    }
}
