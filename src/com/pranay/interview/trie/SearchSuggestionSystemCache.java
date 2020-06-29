package com.pranay.interview.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node{
    Node[] nodes;
    List<String> words;
    public Node(){
        nodes = new Node[26];
        words = new ArrayList<>();
    }
}

public class SearchSuggestionSystemCache {
    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        SearchSuggestionSystemCache ss = new SearchSuggestionSystemCache();
        List<List<String>> ans = ss.suggestedProducts(products, searchWord);
        System.out.println("Ans : " + ans);
    }

    private List<List<String>> suggestedProducts(String[] ps, String w) {
        Arrays.sort(ps);
        Node root = new Node();
        for (String s: ps)
            add(root, s);
        return search(root, w);
    }

    private void add(Node node, String s) {
        for (char c : s.toCharArray()) {
            if (node.nodes[c - 'a'] == null)
                node.nodes[c - 'a'] = new Node();
            node = node.nodes[c - 'a'];

            if (node.words.size() < 3)
                node.words.add(s); // avoid TLE;
        }
    }

    private List<List<String>> search(Node node, String w) {
        List<List<String>> res = new ArrayList<>();
        for (char c: w.toCharArray()) {
            if (node != null)
                node = node.nodes[c - 'a'];
            res.add(node == null ? new ArrayList<>() : node.words);
        }
        return res;
    }
}
