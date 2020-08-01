package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = List.of("apple", "pen", "applepen", "pine", "pineapple");

        WordBreak2 wb = new WordBreak2();
        List<String> ans = wb.wordBreak(s, wordDict);
        System.out.println(ans);
    }

    List<String> res = new ArrayList<>();
    List<String> dict;
    Map<String, LinkedList<String>> cache = new HashMap<>();

    private List<String> wordBreak(String s, List<String> wordDict) {
        dict = wordDict;
//        dfs(s, "");
//        return res;

        // dfs + cache
        return dfs2(s);
    }

    private void dfs(String s, String curr) {
        if (s.length() == 0) {
            res.add(curr.trim());
            return;
        }

        for (String w: dict) {
            if (s.startsWith(w)) {
                dfs(s.substring(w.length()), curr + " " + w);
            }
        }
    }

    // dfs + cache
    private List<String> dfs2(String s) {
        if (cache.containsKey(s))
            return cache.get(s);

        LinkedList<String> cur = new LinkedList<>();

        if (s.length() == 0) {
            cur.add("");
            return cur;
        }

        for (String w: dict) {
            if (s.startsWith(w)) {
                List<String> sublist = dfs2(s.substring(w.length()));

                for (String sub : sublist)
                    cur.add(w + (sub.isEmpty() ? "" : " ") + sub);
            }
        }

        cache.put(s, cur);
        return cur;
    }
}
