package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeDiameter {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{1,4},{4,5}};

        TreeDiameter td = new TreeDiameter();

        int diam = td.treeDiameter(edges);
        System.out.println("Diameter : " + diam);
    }

    int answer = 0;
    int farthest = -1;

    private int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        dfs(map, edges[0][0], new HashSet<>(), 0);
        answer = 0;

        dfs(map, farthest, new HashSet<>(), 0);

        return answer;
    }

    public void dfs (Map<Integer, List<Integer>> map, int key, Set<Integer> seen, int len) {
        if (len > answer) {
            farthest = key;
            answer = len;
        }

        seen.add(key);
        List<Integer> childs = map.get(key);

        for (Integer child: childs) {
            if (!seen.contains(child))
                dfs(map, child, seen, len + 1);
        }
    }
}
