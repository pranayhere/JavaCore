package com.pranay.interview.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Trie {
    int cnt = 0;
    Map<Character, Trie> kids = new HashMap<>();

    public void add(String word) {
        Trie t = this;

        for (char ch: word.toCharArray()) {
            if (!t.kids.containsKey(ch)) {
                t.kids.put(ch, new Trie());
            }

            t = t.kids.get(ch);
            t.cnt += 1;
        }
    }

    public int search(String word) {
        Trie t = this;
        int score = 0;

        for (char ch: word.toCharArray()) {
            if (t.kids.get(ch) == null) {
                return score;
            }

            t = t.kids.get(ch);
            score += t.cnt;
        }

        return score;
    }

}

public class SumOfPrefixScoresOfStrings {
    public static void main(String[] args) {
        String[] words = {"abc","ab","bc","b"};
        SumOfPrefixScoresOfStrings sp = new SumOfPrefixScoresOfStrings();
        int[] ans = sp.sumPrefixScores(words);
        System.out.println(Arrays.toString(ans));
    }

    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.add(word);
        }
        int n = words.length, i = 0;
        int[] scores = new int[n];
        for (String word : words) {
            scores[i++] = root.search(word);
        }
        return scores;
    }
}
