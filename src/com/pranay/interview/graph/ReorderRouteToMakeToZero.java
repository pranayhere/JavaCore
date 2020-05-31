package com.pranay.interview.graph;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReorderRouteToMakeToZero {
    int res=0;
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        ReorderRouteToMakeToZero obj = new ReorderRouteToMakeToZero();
        int minReorder = obj.minReorder(n, connections);
        System.out.println("Min Reorder : " + minReorder);
    }

    private int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] c: connections) {
            map.computeIfAbsent(c[0], k -> new LinkedList<>()).add(c[1]);
            map.computeIfAbsent(c[1], k -> new LinkedList<>()).add(-c[0]);
        }

        System.out.println(map);
        dfs(map, 0, new HashSet<>());
        return res;
    }

    private void dfs(Map<Integer, List<Integer>> map, int curr, Set<Integer> vis) {
        if (!vis.add(Math.abs(curr)))
            return;
        if (curr > 0)
            res++;
        for (int next : map.get(Math.abs(curr))) {
            dfs(map, next, vis);
        }
        vis.remove(curr);
    }
}
