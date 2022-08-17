package com.pranay.interview.graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        int len = ladderLength(beginWord, endWord, wordList);
        System.out.println("Ladder len : " + len);
    }

    private static int ladderLength(String beginWord, String endWord, String[] wordList) {
        Map<String, List<String>> dict = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String w = word.substring(0, i) + "*" + word.substring(i + 1);
                dict.computeIfAbsent(w, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<Map.Entry<String, Integer>> q = new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry<>(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!q.isEmpty()) {
            Map.Entry<String, Integer> curr = q.poll();
            String word = curr.getKey();
            int steps = curr.getValue();

            for (int i = 0; i < word.length(); i++) {
                String w = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> adjWords = dict.getOrDefault(w, new ArrayList<>());

                for (String next : adjWords) {
                    if (next.equals(endWord)) {
                        return steps + 1;
                    }
                    if (!visited.containsKey(next)) {
                        visited.put(next, true);
                        q.offer(new AbstractMap.SimpleEntry<>(next, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
