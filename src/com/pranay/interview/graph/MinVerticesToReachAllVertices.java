package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1557. Minimum Number of Vertices to Reach All Nodes
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class MinVerticesToReachAllVertices {
    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(List.of(0, 1));
        edges.add(List.of(0, 2));
        edges.add(List.of(2, 5));
        edges.add(List.of(3, 4));
        edges.add(List.of(4, 2));

        MinVerticesToReachAllVertices vert = new MinVerticesToReachAllVertices();
        List<Integer> vertices = vert.findSmallestSetOfVertices(n, edges);
        System.out.println(vertices);
    }

    private List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];

        for (int i = 0; i < edges.size(); i++) {
            int dest = edges.get(i).get(1);
            indegree[dest]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                res.add(i);
        }
        return res;
    }
}
