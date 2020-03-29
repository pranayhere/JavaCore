package com.pranay.GeeksForGeeks;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

		Map<String, List<String>> allComboDict = new HashMap<>();
		for (String word: wordList) {
			for (int i=0; i<word.length(); i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i+1, word.length());
				List<String> combo = allComboDict.getOrDefault(newWord, new ArrayList<>());
				combo.add(word);
				allComboDict.put(newWord, combo);
			}
		}

		allComboDict.forEach((k, v) -> System.out.println(k + " = " + v));
		Queue<Pair<String, Integer>> Q = new LinkedList<>();
		Q.add(new Pair<>(beginWord, 1));

		Map<String, Boolean> visited = new HashMap<>();
		visited.put(beginWord, true);

		while(!Q.isEmpty()) {
			Pair<String, Integer> node = Q.remove();
			String word = node.getKey();
			int level = node.getValue();

			for (int i=0; i<L; i++) {
				String newWord = word.substring(0, i) + "*" + word.substring(i+1, word.length());

				List<String> adjacentWords = allComboDict.getOrDefault(newWord, new ArrayList<>());
				for (String adjacentWord: adjacentWords) {
					if (adjacentWord.equals(endWord)) {
						return level + 1;
					}

					if (!visited.containsKey(adjacentWord)) {
						visited.put(adjacentWord, true);
						Q.add(new Pair<>(adjacentWord, level + 1));
					}
				}
			}
		}
		return 0;
	}
}
