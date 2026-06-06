package com.pranay.interview.dp;

public class DistinctSubsequences {
    public static void main(String[] args) {
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "rabbbit", t = "rabbit";
        int ways = ds.numDistinct(s, t);
        System.out.println(ways);
    }

    public int numDistinct(String s, String t) {
        return dfs(s, 0, t, 0);
    }

    public int dfs(String s, int i, String t, int j) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (s.charAt(i) == t.charAt(j)) {
            return dfs(s, i + 1, t, j) + dfs(s, i + 1, t, j + 1);
        } else {
            return dfs(s, i + 1, t, j);
        }
    }
}
