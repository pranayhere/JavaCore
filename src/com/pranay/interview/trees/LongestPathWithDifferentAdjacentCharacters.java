package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPathWithDifferentAdjacentCharacters {
    public static void main(String[] args) {
        int[] parent = {-1,0,0,1,1,2};
        String s = "abacbe";

        LongestPathWithDifferentAdjacentCharacters lp = new LongestPathWithDifferentAdjacentCharacters();
        int len = lp.longestPath(parent, s);
        System.out.println("Ans : " + len);
    }

    int max = 0;
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int p = parent[i];
            if (p == -1)
                continue;

            map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }

        dfs(map, 0, s);
        return max;
    }

    public int dfs(Map<Integer, List<Integer>> map, int curr, String s) {
        int max1 = -1;
        int max2 = -1;

        for (int c: map.getOrDefault(curr, new ArrayList<>())) {
            int res = dfs(map, c, s);

            if (s.charAt(curr) != s.charAt(c)) {
                if (res > max1) {
                    max2 = max1;
                    max1 = res;
                } else if (res > max2) {
                    max2 = res;
                }
            }
        }

        max1 = max1 == -1 ? 0 : max1;
        max2 = max2 == -1 ? 0 : max2;

        max = Math.max(max1 + max2 + 1, max);
        return max1 + 1;
    }
}
