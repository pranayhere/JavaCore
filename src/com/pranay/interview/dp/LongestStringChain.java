package com.pranay.interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1048. Longest String Chain
 * https://leetcode.com/problems/longest-string-chain/
 *
 * Instead of adding a character, try deleting a character to form a chain in reverse.
 * For each word in order of length, for each word2 which is word with one character removed, length[word2] = max(length[word2], length[word] + 1).
 */

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        LongestStringChain l = new LongestStringChain();
        int len = l.longestStrChain(words);
        System.out.println("Length : " + len);
    }

    Set<String> set;

    private int longestStrChain(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        set = new HashSet<>(Arrays.asList(words));

        int maxChain = 0;
        for (int i = words.length - 1; i >= 0; i--) {
        //    Map<String, Integer> memo = new HashMap<>();
        //    int currChain = dfs(words[i], memo, set, 1);

            int currChain = dfs2(words[i]);
            maxChain = Math.max(currChain, maxChain);
        }

        return maxChain;
    }

    private int dfs(String w, Map<String, Integer> memo, Set<String> set, int chain) {
        if (!set.contains(w))
            return 0;

        if (memo.containsKey(w))
            return memo.get(w);

        int maxChain = chain;

        for (int i = 0; i < w.length(); i++) {
            String word = w.substring(0, i) + w.substring(i+1);
            maxChain = Math.max(maxChain, dfs(word, memo, set, chain + 1));
        }
        memo.put(w, maxChain);
        return maxChain;
    }

    // #pattern
    private int dfs2(String w) {
        if (!set.contains(w))
            return 0;

        int maxChain = 0;

        for (int i = 0; i < w.length(); i++) {
            String s = w.substring(0, i) + w.substring(i + 1);
            int curChain = dfs2(s);
            maxChain = Math.max(curChain, maxChain);
        }

        return ++maxChain;
    }
}
