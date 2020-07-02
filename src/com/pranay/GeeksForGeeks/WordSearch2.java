package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode {
    TrieNode[] nodes;
    boolean isW;

    public TrieNode() {
        nodes = new  TrieNode[26];
        isW = false;
    }
}

/**
 *
 * https://leetcode.com/problems/word-search-ii
 *
 * 27 / 36 test cases passed. not correct ans, something is missed
 * Input:
 * [["a","a"]]
 * ["aaa"]
 * Output:
 * ["aaa"]
 * Expected:
 * []
 */
public class WordSearch2 {

    public static void main(String[] args) {
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
//
//        String[] words = {"oath","pea","eat","rain"};

        char[][] board = {{'a', 'a'}};
        String[] words = {"aaa"};
        WordSearch2 ws2 = new WordSearch2();
        List<String> found = ws2.wordSearch(board, words);
        System.out.println("Ans : " + found);
    }

    TrieNode root;
    Set<String> res = new HashSet<>();
    private List<String> wordSearch(char[][] board, String[] words) {
        root = new TrieNode();
        buildTrie(words);

        int nr = board.length;
        int nc = board[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (root.nodes[board[r][c] - 'a'] != null) {
                    String path = "";
                    dfs(board, r, c, root, path);
                }
            }
        }
        return new ArrayList<>(res);
    }

    private void buildTrie(String[] words) {
        for (String word: words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.nodes[c - 'a'] == null) {
                    node.nodes[c - 'a'] = new TrieNode();
                }
                node = node.nodes[c - 'a'];
            }
            node.isW = true;
        }
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, String path) {
        char letter = board[r][c];
        TrieNode currNode = parent.nodes[letter - 'a'];

        path += (char) letter;

        if (currNode.isW) {
            res.add(path);
        }

        board[r][c] = '#';
        int[] rowOffset = {-1, 1, 0, 0};
        int[] colOffset = {0, 0, 1, -1};

        for (int i = 0; i < 4; ++i) {
            int newR = r + rowOffset[i];
            int newC = c + colOffset[i];

            if (newR < 0 || newR >= board.length || newC < 0 || newC >= board[0].length || board[newR][newC] == '#') {
                continue;
            }

            if (currNode.nodes[board[newR][newC] - 'a'] != null) {
                dfs(board, newR, newC, currNode, path);
                path = path.substring(0, path.length() - 1);
            }
        }

        board[r][c] = letter;
    }
}
