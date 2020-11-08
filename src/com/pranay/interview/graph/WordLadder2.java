package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordLadder2 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

//        String beginWord = "hot";
//        String endWord = "dog";
//        List<String> wordList = Arrays.asList("hot", "dog");

        WordLadder2 wl = new WordLadder2();
        List<List<String>> ans = wl.findLadders(beginWord, endWord, wordList);
        for (List<String> list: ans) {
            System.out.println(list);
        }
    }

    TreeMap<Integer, List<List<String>>> tm = new TreeMap<>();
    Map<String, List<String>> hm = new HashMap<>();
    int currMin = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return new ArrayList<>();

        for (String s: wordList) {
            for (int i = 0; i < s.length(); i++) {
                String newWord = s.substring(0, i) + "*" + s.substring(i + 1);
                hm.computeIfAbsent(newWord, k -> new ArrayList<>()).add(s);
            }
        }

        ArrayList<String> curr = new ArrayList<>();
        curr.add(beginWord);

        dfs(beginWord, endWord, curr, new HashSet<>());
        if (tm.isEmpty())
            return new ArrayList<>();
        return tm.getOrDefault(tm.firstKey(), new ArrayList<>());
    }

    private void dfs(String curr, String endWord, ArrayList<String> list, HashSet<String> seen) {
        if (list.size() > currMin)
            return;

        if (curr.equals(endWord)) {
            List<List<String>> newList = tm.getOrDefault(list.size(), new ArrayList<>());
            newList.add(new ArrayList<>(list));
            tm.put(list.size(), newList);
            currMin = list.size();
            return;
        }

        for (int i = 0; i < curr.length(); i++) {
            String newWord = curr.substring(0, i) + "*" + curr.substring(i + 1);

            for (String adjWord: hm.getOrDefault(newWord, new ArrayList<>())) {
                if (!seen.contains(adjWord)) {
                    seen.add(adjWord);
                    list.add(adjWord);
                    dfs(adjWord, endWord, list, seen);
                    seen.remove(adjWord);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
