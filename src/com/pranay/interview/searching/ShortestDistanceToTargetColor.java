package com.pranay.interview.searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistanceToTargetColor {
    public static void main(String[] args) {
//        int[] colors = {1, 1, 2, 1, 3, 2, 2, 3, 3};
//        int[][] queries = {{1, 3}, {2, 2}, {6, 1}};
//        int[] colors = {1, 2};
//        int[][] queries = {{0, 3}};
        int[] colors = {2, 1, 2, 2, 1};
        int[][] queries = {{1, 1}, {4, 3}, {1, 3}, {4, 2}, {2, 1}};

        ShortestDistanceToTargetColor s = new ShortestDistanceToTargetColor();
        List<Integer> ans = s.shortestDistanceColor(colors, queries);
        System.out.println("Ans : " + ans);
    }

    Map<Integer, List<Integer>> indexMap = new HashMap<>();

    private List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < colors.length; i++)
            indexMap.computeIfAbsent(colors[i], k -> new ArrayList<>()).add(i);

        for (int[] q : queries) {
            int idx = q[0];
            int num = q[1];

            if (!indexMap.containsKey(num)) {
                ans.add(-1);
                continue;
            }

            List<Integer> indices = indexMap.get(num);
            int index = binarySearch(indices, idx);
            ans.add(index);
        }
        return ans;
    }

    private int binarySearch(List<Integer> indices, int idx) {
        int lo = 0, hi = indices.size() - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int M = indices.get(mid);
            if (M < idx)
                lo = mid + 1;
            else
                hi = mid;
        }

        int res = lo;
        if (lo - 1 >= 0 && idx - indices.get(lo - 1) < indices.get(lo) - idx) {
            res = lo - 1;
        }
        return Math.abs(indices.get(res) - idx);
    }
}
