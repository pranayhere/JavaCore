package com.pranay.interview.graph;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * char[][] board = {
 *     {'A','B','C','E'},
 *     {'S','F','E','S'},
 *     {'A','D','E','E'}
 * };
 *
 * String word = "ABCESEEEFS";
 * ANS : TRUE
 */

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        String word = "ABCESEEEFSD";
        boolean wordExists = exist(board, word);

        System.out.println("Word Exists : " + wordExists);
    }

    private static boolean exist(char[][] board, String word) {
        int nr = board.length;
        int nc = board[0].length;

        boolean ans = false;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, new boolean[nr][nc], word, r, c, 0)) {
                        return true;
                    }

                }
            }
        }
        return ans;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, String word, int r, int c, int i) {
        int nr = board.length;
        int nc = board[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || i >= word.length() || board[r][c] != word.charAt(i) || visited[r][c])
            return false;

        visited[r][c] = true;
        if (i == word.length() - 1)
            return true;

        boolean exists = dfs(board, visited, word, r + 1, c, i + 1)
                || dfs(board, visited, word, r - 1, c, i + 1)
                || dfs(board, visited, word, r, c + 1, i + 1)
                || dfs(board, visited, word, r, c - 1, i + 1);

        visited[r][c] = false;
        return exists;
    }
}
