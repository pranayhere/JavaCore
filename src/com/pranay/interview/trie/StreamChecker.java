package com.pranay.interview.trie;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class StreamChecker {
    static class TrieNode {
        Map<Character, TrieNode> childs = new HashMap<>();
        boolean isWord = false;
    }

    TrieNode trie = new TrieNode();
    Deque<Character> stream = new ArrayDeque<>();

    public StreamChecker(String[] words) {
        for (String word: words) {
            TrieNode node = trie;
            String reverseWord = new StringBuffer(word).reverse().toString();

            for (char ch: reverseWord.toCharArray()) {
                if (!node.childs.containsKey(ch)) {
                    node.childs.put(ch, new TrieNode());
                }

                node = node.childs.get(ch);
            }

            node.isWord = true;
        }
    }

    public boolean query(char letter) {
        stream.addFirst(letter);

        TrieNode node = trie;
        for (char ch: stream) {
            if (node.isWord) {
                return true;
            }

            if (!node.childs.containsKey(ch)) {
                return false;
            }

            node = node.childs.get(ch);
        }

        return node.isWord;
    }

    public static void main(String[] args) {
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        streamChecker.query('a'); // return False
        streamChecker.query('b'); // return False
        streamChecker.query('c'); // return False
        streamChecker.query('d'); // return True, because 'cd' is in the wordlist
        streamChecker.query('e'); // return False
        streamChecker.query('f'); // return True, because 'f' is in the wordlist
        streamChecker.query('g'); // return False
        streamChecker.query('h'); // return False
        streamChecker.query('i'); // return False
        streamChecker.query('j'); // return False
        streamChecker.query('k'); // return False
        streamChecker.query('l'); // return True, because 'kl' is in the wordlist
    }
}
