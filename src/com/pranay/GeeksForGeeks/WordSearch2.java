package com.pranay.GeeksForGeeks;

public class WordSearch2 {

	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
			};
		
		String word = "abcd";
		boolean isPresent = wordSearch(board, word);
		System.out.println(isPresent);
	}

	private static boolean wordSearch(char[][] board, String word) {
		if (board.length == 0) return false;
		int x = board.length;
		int y = board[0].length;
		
		return false;
	}

}
