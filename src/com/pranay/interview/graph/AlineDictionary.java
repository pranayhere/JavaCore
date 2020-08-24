package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/alien-dictionary
 * Explanation :  https://www.youtube.com/watch?v=RPpnRavqb8g
 *
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * similar question : Sequence Reconstruction
 */
public class AlineDictionary {
    public static void main(String[] args) {
        String[] words = {"za","zb","ca","cb"};
//["wrt","wrf","er","ett","rftt"]
//["za","zb","ca","cb"]
        AlineDictionary ad = new AlineDictionary();
        String orderOfLetters = ad.alienOrder(words);
        System.out.println("Order Of Letters : " + orderOfLetters);
    }

    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();

    public String alienOrder(String[] words) {
        for (String word: words) {
            for (char ch: word.toCharArray()) {
                indegree.put(ch, 0);
                graph.put(ch, new ArrayList<>());
            }
        }

        System.out.println("Indegree : " + indegree);
        System.out.println("Adjacency List : " + graph);

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return ""; // to avoid conditions like {appium, app}
            }

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    break;
                }
            }
        }

        System.out.println(graph);
        System.out.println(indegree);

        Queue<Character> q = new ArrayDeque<>();
        for (char node: indegree.keySet()) {
            if (indegree.get(node) == 0)
                q.offer(node);
        }


        String topologicalSort = "";
        while (!q.isEmpty()) {
            char node = q.poll();
            topologicalSort += node;

            for (char next: graph.get(node)) {
                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0)
                    q.offer(next);
            }
        }

        System.out.println(topologicalSort);
        if (topologicalSort.length() < indegree.size()) {
            return "";
        }

        return topologicalSort;
    }
}