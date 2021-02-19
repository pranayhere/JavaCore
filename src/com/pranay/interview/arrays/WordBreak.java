package com.pranay.interview.arrays;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        boolean ans = wordBreakBFS(s, wordDict);
        boolean ans2 = wordBreakDP(s, wordDict);
        System.out.println("Ans bfs: " + ans);
        System.out.println("Ans Dp : " + ans2);
    }

    private static boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i<=s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hs.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }

    private static boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[s.length()];
        q.offer(0);

        while (!q.isEmpty()) {
            int start = q.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (hs.contains(s.substring(start, end))) {
                        q.offer(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }

        }
        return false;
    }

    // few test cases will fail 36/40 passed
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> hs = new HashSet<>(wordDict);
//        dfs(s, hs);
//
//        return ans;
//    }
//
//    public void dfs(String s, Set<String> hs) {
//        if (ans == true)
//            return;
//
//        if (s.equals("")) {
//            ans = true;
//            return;
//        }
//
//        for (String str: hs) {
//            if (s.startsWith(str)) {
//                String st = s.substring(str.length());
//                dfs(st, hs);
//            }
//        }
//    }
}
