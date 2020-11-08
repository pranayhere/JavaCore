package com.pranay.GeeksForGeeks;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		int len = ladderLength(beginWord, endWord, wordList);
		System.out.println(len);
	}

	private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int L = beginWord.length();
		Map<String, List<String>> hm = new HashMap<>();
		for (String s: wordList) {
		    for (int i = 0; i < s.length(); i++) {
		        String newWord = s.substring(0, i) + "*" + s.substring(i + 1);
		        hm.computeIfAbsent(newWord, k -> new ArrayList<>()).add(s);
            }
        }
        hm.forEach((k, v) -> System.out.println(k + " - " + v));

		Queue<Pair<String, Integer>> q = new ArrayDeque<>();
		Set<String> seen = new HashSet<>();

		q.offer(new Pair<>(beginWord, 1));

		while (!q.isEmpty()) {
		    Pair<String, Integer> p = q.poll();
		    String w = p.getKey();
		    int level = p.getValue();

		    for (int i = 0; i < w.length(); i++) {
		        String newWord = w.substring(0, i) + "*" + w.substring(i + 1);
		        if (!hm.containsKey(newWord)) {
		            continue;
                }

		        for (String adjWord: hm.getOrDefault(newWord, new ArrayList<>())) {
		            if (adjWord.equals(endWord))
		                return level + 1;

                    if (!seen.contains(adjWord)) {
                        seen.add(adjWord);
                        q.offer(new Pair<>(adjWord, level + 1));
                    }
                }
            }
        }
	    return 0;
	}
}
