package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 425. Word Squares
 * https://leetcode.com/problems/word-squares/
 *
 * https://leetcode.com/problems/word-squares/solution/
 */
public class WordSquare {
    public static void main(String[] args) {
        String[] words = {"ball", "able", "area", "lead", "lady"};
        WordSquare ws = new WordSquare();
        List<List<String>> ans = ws.wordSquares(words);
        System.out.println("Ans : " + ans);
    }

    int N = 0;
    String[] words;
    HashMap<String, List<String>> prefixTable = new HashMap<>();

    private List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.N = words[0].length();

        List<List<String>> results = new ArrayList<>();
        buildPrefixTable(words);

        for (String word: words) {
            List<String> wordSquare = new ArrayList<>();
            wordSquare.add(word);
            backtrack(1, wordSquare, results);
        }

        return results;
    }

    private void backtrack(int step, List<String> wordSquare, List<List<String>> results) {
        if (step == N) {
            results.add(new ArrayList<>(wordSquare));
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquare) {
            prefix.append(word.charAt(step));
        }

        for (String next: prefixTable.getOrDefault(prefix.toString(), new ArrayList<>())) {
            wordSquare.add(next);
            backtrack(step + 1, wordSquare, results);
            wordSquare.remove(wordSquare.size() - 1);
        }
    }

    private void buildPrefixTable(String[] words) {
        for (String word: words) {
            for (int i = 1; i < N; i++) {
                String substr = word.substring(0, i);
                prefixTable.computeIfAbsent(substr, k -> new ArrayList<>()).add(word);
            }
        }
        System.out.println(prefixTable);
    }
}