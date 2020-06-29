package com.pranay.interview.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/search-suggestions-system/discuss/673886/Java-sort-then-try-with-suggestion-Cache-VS-trie-wo-cache

class TrieNode {
    TrieNode[] nodes;
    boolean isW; // isEnd

    public TrieNode() {
        nodes = new TrieNode[26];
        isW = false;
    }
}

public class SearchSuggestionSystem {
    TrieNode root;
    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        SearchSuggestionSystem ss = new SearchSuggestionSystem();
        List<List<String>> ans = ss.suggestedProducts(products, searchWord);
        System.out.println("Ans : " + ans);
    }

    private List<List<String>> suggestedProducts(String[] products, String w) {
        root = new TrieNode();
        for (String s: products) {
            add(s);
        }
        return search(w);
    }

    private void add(String s) {
        TrieNode node = root;
        for (char c: s.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new TrieNode();
            }
            node = node.nodes[c - 'a'];
        }
        node.isW = true;
    }

    private List<List<String>> search(String w) {
        List<List<String>> res = new ArrayList<>();
        TrieNode node = root;
        String path = "";
        for (char c : w.toCharArray()) {
            if (node == null) {
                node = null;
                res.add(new ArrayList<>());
                continue;
            } else {
                node = node.nodes[c - 'a'];
            }
            path = path + String.valueOf(c);
            res.add(getSuggestions(node, path));
        }
        return res;
    }

    private List<String> getSuggestions(TrieNode node, String path) {
        List<String> res = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        dfs(node, path, pq);
        while (!pq.isEmpty())
            res.add(0, pq.poll());
        return res;
    }

    private void dfs(TrieNode node, String path, PriorityQueue<String> pq) {
        if (node == null)
            return;

        if (node.isW)
            pq.offer(path);

        if (pq.size() > 3)
            pq.poll();

        for (int i = 0; i<26; i++) {
            char c = (char) ('a' + i);
            dfs(node.nodes[c - 'a'], path + String.valueOf(c), pq);
        }
    }


}
