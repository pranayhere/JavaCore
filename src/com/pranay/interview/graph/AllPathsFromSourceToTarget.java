package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = {{1,2}, {3}, {3}, {}};
        AllPathsFromSourceToTarget apst = new AllPathsFromSourceToTarget();
        List<List<Integer>> paths = apst.allPathsSourceTarget(graph);
        System.out.println(paths);
    }

    List<List<Integer>> allPaths = new ArrayList<>();
    private List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, graph.length - 1, new ArrayList<>());
        return allPaths;
    }

    private void dfs(int[][] graph, int src, int target, List<Integer> currPath) {
        if (src > graph.length)
            return;

        currPath.add(src);

        if (src == target) {
            allPaths.add(new ArrayList<>(currPath));
        }

        for (int next: graph[src]) {
            dfs(graph, next, target, currPath);
        }

        currPath.remove(currPath.size() - 1);
    }
}
