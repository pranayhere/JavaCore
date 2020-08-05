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

    private Map<Character, List<Character>> adjList = new HashMap<>();
    private Map<Character, Integer> indegree = new HashMap<>();

    private String alienOrder(String[] words) {
        for (int i = 0; i<words.length; i++) {
            for (Character ch: words[i].toCharArray()) {
                indegree.put(ch, 0);
                adjList.putIfAbsent(ch, new ArrayList<>());
            }
        }

        System.out.println("Indegree : " + indegree);
        System.out.println("Adjacency List : " + adjList);

        for (int i = 0; i<words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return ""; // to avoid conditions like {appium, app}
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        System.out.println("Indegree : " + indegree);
        System.out.println("Adjacency List : " + adjList);

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();

        for (Character ch: indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                q.offer(ch);
            }
        }

        while (!q.isEmpty()) {
            Character ch = q.remove();
            sb.append(ch);

            for (Character next: adjList.get(ch)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0)
                    q.offer(next);
            }
        }

        if (sb.length() < indegree.size()) {
            return "";
        }
        return sb.toString();
    }
}