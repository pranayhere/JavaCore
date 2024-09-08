package com.pranay.interview.graph;

import java.util.*;

/**
 * Explanation
 * https://www.youtube.com/watch?v=4Y_m-pSYA9c
 * https://leetcode.com/problems/evaluate-division/discuss/278276/Java-Union-find-and-DFS
 *
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */

public class EvaluateDivisionDFS {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        EvaluateDivisionDFS ee = new EvaluateDivisionDFS();
        double ans[] = ee.calcEquation(equations, values, queries);
        System.out.println("Result : " + Arrays.toString(ans));
    }

    Map<String, Map<String, Double>> g = new HashMap<>();
    Map<String, Boolean> seen = new HashMap<>();
    Map<String, String> roots = new HashMap<>();
    Map<String, Double> vals = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);

            g.computeIfAbsent(src, k -> new HashMap<>()).put(dest, values[i]);
            g.computeIfAbsent(dest, k -> new HashMap<>()).put(src, 1 / values[i]);
        }

        for (String vertex: g.keySet()) {
            if (!seen.containsKey(vertex)) {
                dfs(vertex, vertex, 1);
            }
        }

        int m = queries.size();
        double[] res = new double[m];

        for (int i = 0; i < m; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            String rootX = roots.getOrDefault(x, x);
            String rootY = roots.getOrDefault(y, y);

            if (rootX != rootY)
                res[i] = -1.0;
            else
                res[i] = vals.get(x) / vals.get(y);
        }

        return res;
    }

    public void dfs(String curr, String parent, double val) {
        seen.put(curr, true);
        roots.put(curr, parent);
        vals.put(curr, val);

        for (String neigh: g.getOrDefault(curr, new HashMap<>()).keySet()) {
            if (!seen.containsKey(neigh)) {
                dfs(neigh, parent, val * g.get(neigh).get(curr));
            }
        }
    }
}