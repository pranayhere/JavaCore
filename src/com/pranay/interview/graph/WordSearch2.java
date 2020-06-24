package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Simple Trie

/**
 * https://leetcode.com/problems/word-search-ii/
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 */

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode() {}

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + children +
                ", word='" + word + '\'' +
                '}';
    }
}

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        WordSearch2 ws2 = new WordSearch2();
        String[] words = {"oath","pea","eat","rain"};
        List<String> wordsInBoard = ws2.findWords(board, words);
        System.out.println("Words in board : " + wordsInBoard);
    }

    char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();

    private List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode node = root;

            for (Character letter: word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        this._board = board;

        int nr = board.length;
        int nc = board[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (root.children.containsKey(board[r][c])) {
                    dfs (r, c, root);
                }
            }
        }
        return this._result;
    }

    private void dfs(int r, int c, TrieNode parent) {
        Character letter = this._board[r][c];
        TrieNode current = parent.children.get(letter);

        if (current.word != null) {
            this._result.add(current.word);
            current.word = null;
        }

        int nr = _board.length;
        int nc = _board[0].length;

        this._board[r][c] = '#';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        for (int i = 0; i<4; i++) {
            int newRow = r + rowOffset[i];
            int newCol = c + colOffset[i];

            if (newRow < 0 || newRow >= nr || newCol < 0 || newCol >= nc)
                continue;

            if (current.children.containsKey(_board[newRow][newCol]))
                dfs(newRow, newCol, current);
        }

        _board[r][c] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (current.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}
