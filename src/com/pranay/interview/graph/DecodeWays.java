package com.pranay.interview.graph;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";

        DecodeWays dw = new DecodeWays();
        int count = dw.numDecodings(s);
        System.out.println("Num of decoding : " + count);
    }

    private int numDecodings(String s) {
        if (s.length() == 0)
            return 0;

        return dfsMemo(s, 0);
    }

    private int dfs(String s, int i) {
        if (i == s.length())
            return 1;

        if (i == s.length() - 1)
            return 1;

        if (s.charAt(i) == '0')
            return 0;

        int ans = dfs(s, i + 1);
        if (Integer.parseInt(s.substring(i, i + 2)) <= 26)
            ans += dfs(s, i + 2);

        return ans;
    }

    // dfs + cache
    Map<Integer, Integer> cache = new HashMap<>();

    private int dfsMemo(String s, int i) {
        if (i == s.length())
            return 1;

        if (i == s.length() - 1)
            return 1;

        if (s.charAt(i) == '0')
            return 0;

        if (cache.containsKey(i))
            return cache.get(i);

        int ans = dfsMemo(s, i + 1);
        if (Integer.parseInt(s.substring(i, i + 2)) <= 26)
            ans += dfsMemo(s, i + 2);

        cache.put(i, ans);
        return ans;
    }
}
