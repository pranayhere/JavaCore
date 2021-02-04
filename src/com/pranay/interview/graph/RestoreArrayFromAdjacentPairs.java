package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RestoreArrayFromAdjacentPairs {
    public static void main(String[] args) {
        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        RestoreArrayFromAdjacentPairs rap = new RestoreArrayFromAdjacentPairs();
        int[] arr = rap.restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(arr));
    }

    List<Integer> ans = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();

    private  int[] restoreArray(int[][] adjacentPairs) {
        for (int[] ap: adjacentPairs) {
            graph.computeIfAbsent(ap[0], k -> new ArrayList<>()).add(ap[1]);
            graph.computeIfAbsent(ap[1], k -> new ArrayList<>()).add(ap[0]);
            hs.add(ap[0]);
            hs.add(ap[1]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int k: graph.keySet()) {
            if (graph.get(k).size() == 1)
                q.offer(k);
        }

        while (!q.isEmpty()) {
            int start = q.poll();
            HashSet<Integer> seen = new HashSet<>();
            dfs(start, seen, new ArrayList<>());
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);

        return res;
    }

    private void dfs(int start, HashSet<Integer> seen, ArrayList<Integer> curr) {
        if (curr.size() == hs.size()) {
            ans = new ArrayList<>(curr);
            return;
        }

        if (seen.contains(start))
            return;

        curr.add(start);
        seen.add(start);
        for (int adj: graph.get(start)) {
            dfs(adj, seen, curr);
        }
    }
}
