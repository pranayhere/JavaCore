package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		
//		char[][] board = {
//				{'a','b'},{'c','d'}
//			};

		String word = "abcd";
		boolean isPresent = wordSearch(board, word);
		System.out.println(isPresent);
	}

	private static boolean wordSearch(char[][] board, String word) {
		Map<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i<board.length; i++) {
			for (int j = 0; j< board[0].length; j++) {
//				System.out.print(board[i][j]);
				hm.put(board[i][j], hm.getOrDefault(board[i][j], 0)+1);
			}
			System.out.println();
		}
		
		hm.forEach((k, v) -> {
			System.out.println(k + " :" +v);
		});
		
		for (Character ch : word.toCharArray()) {
			if (hm.containsKey(ch)) {
				int count = hm.get(ch) - 1;
				if (count == 0) {
					hm.remove(ch);
				} else {
					hm.put(ch, count);					
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
