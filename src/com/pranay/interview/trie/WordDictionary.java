package com.pranay.interview.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> childs = new HashMap<>();
        boolean isWord = false;

        TrieNode() {}

        @Override
        public String toString() {
            return "TrieNode{" +
                    "childs=" + childs +
                    ", isWord=" + isWord +
                    '}';
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");

        System.out.println(wd.trie);
        wd.search("pad"); // -> false
        wd.search("bad"); // -> true
        wd.search(".ad"); // -> true
        wd.search("b.."); // -> true
    }

    TrieNode trie;

    WordDictionary() {
        trie = new TrieNode();
    }

    private void addWord(String word) {
        TrieNode node = trie;

        for (char ch: word.toCharArray()) {
            if (!node.childs.containsKey(ch)) {
                node.childs.put(ch, new TrieNode());
            }

            node = node.childs.get(ch);
        }
        node.isWord = true;
    }

    private boolean search(String word) {
        return searchInNode(word, trie);
    }

    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!trie.childs.containsKey(ch)) {
                if (ch == '.') {
                    for (char x : node.childs.keySet()) {
                         TrieNode child = node.childs.get(x);
                        if (searchInNode(word.substring(i + 1), child))
                            return true;
                    }
                }
                return false;
            } else {
                node = node.childs.get(ch);
            }
        }

        return node.isWord;
    }
}
