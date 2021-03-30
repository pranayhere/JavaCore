package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LexicallySmallestEquivalentString {
    public static void main(String[] args) {
        String A = "parker", B = "morris", S = "parser";
        LexicallySmallestEquivalentString ls = new LexicallySmallestEquivalentString();
        String ans = ls.smallestEquivalentString(A, B, S);
        System.out.println("Ans : " + ans);
    }

    Map<Character, List<Character>> graph = new HashMap<>();
    private String smallestEquivalentString(String A, String B, String S) {
        for (int i = 0; i < A.length(); i++) {
            char ch1 = A.charAt(i);
            char ch2 = B.charAt(i);

            graph.computeIfAbsent(ch1, k -> new ArrayList<>()).add(ch2);
            graph.computeIfAbsent(ch2, k -> new ArrayList<>()).add(ch1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            PriorityQueue<Character> pq = new PriorityQueue<>();
            Set<Character> seen = new HashSet<>();

            dfs(ch, pq, seen);
            sb.append(pq.peek());
        }
        return sb.toString();
    }

    public void dfs(char ch, PriorityQueue<Character> pq, Set<Character> seen) {
        if (seen.contains(ch))
            return;

        seen.add(ch);
        pq.offer(ch);
        for (Character neigh: graph.getOrDefault(ch, new ArrayList<>())) {
            dfs(neigh, pq, seen);
        }
    }
}
