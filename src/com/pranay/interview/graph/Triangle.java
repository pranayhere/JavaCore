package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        Triangle t = new Triangle();
        int ans = t.minimumTotal(triangle);
        System.out.println("Ans : " + ans);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, triangle.size(), 0);
    }

    public int dfs(List<List<Integer>> triangle, int listIdx, int idx) {
        if (listIdx == 0)
            return 0;

        if (idx < 0 || idx >= triangle.get(listIdx - 1).size())
            return 0;

        int sum = triangle.get(listIdx - 1).get(idx);

        for (int i = idx; i < triangle.get(listIdx - 1).size(); i++)
            sum +=  Math.min(dfs(triangle, listIdx - 1, i - 1), dfs(triangle, listIdx - 1, i));

        return sum;
    }
}
