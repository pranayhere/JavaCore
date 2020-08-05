package com.pranay.interview.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 745. Prefix and Suffix Search
 * https://leetcode.com/problems/prefix-and-suffix-search/solution/
 *
 * Intuition and Algorithm
 * Consider the word 'apple'. For each suffix of the word, we could insert that suffix, followed by '#', followed by the word, all into the trie.
 *
 * For example, we will insert '#apple', 'e#apple', 'le#apple', 'ple#apple', 'pple#apple', 'apple#apple' into the trie.
 * Then for a query like prefix = "ap", suffix = "le", we can find it by querying our trie for le#ap.
 */
public class PrefixAndSuffixSearch {

    class TrieNode {
        Map<Character, TrieNode> childs = new HashMap<>();
        int weight = 0;

        TrieNode() {}
    }

    TrieNode trie;

    public PrefixAndSuffixSearch(String[] words) {
        trie = new TrieNode();
        int wt = 0;
        for (String word: words) {
            String newWord = "{" + word;
            add(newWord, wt);

            for (int j = word.length() - 1; j >= 0; j--) {
                newWord = word.charAt(j) + newWord;
                add(newWord, wt);
            }
            wt++;
        }
    }

    public void add(String word, int weight) {
        TrieNode node = trie;

        for (char ch: word.toCharArray()) {
            if (!node.childs.containsKey(ch))
                node.childs.put(ch, new TrieNode());

            node = node.childs.get(ch);
            node.weight = weight;
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode node = trie;

        for (char ch: (suffix + "{" + prefix).toCharArray()) {
            if (!node.childs.containsKey(ch))
                return -1;

            node = node.childs.get(ch);
        }

        return node.weight;
    }

    public static void main(String[] args) {
        PrefixAndSuffixSearch ps = new PrefixAndSuffixSearch(new String[] {"apple"});
        ps.f("a", "e");
        ps.f("b", "");
    }
}
