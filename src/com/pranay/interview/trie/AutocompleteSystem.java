package com.pranay.interview.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> childrens;
        Map<String, Integer> counts;
        boolean isW; // isWord

        public TrieNode() {
            childrens = new HashMap<>();
            counts = new HashMap<>();
            isW = false;
        }
    }

    class Pair {
        String s;
        int c;

        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }

    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            TrieNode next = curr.childrens.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.childrens.put(c, next);
            }
            curr = next;
            curr.counts.put(s, count);
        }
        curr.isW = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix += c;
        TrieNode curr = root;

        for (char cc : prefix.toCharArray()) {
            TrieNode next = curr.childrens.get(cc);
            if (next == null) {
                return new ArrayList<String>();
            }
            curr = next;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c) ? a.s.compareTo(b.s) : b.c - a.c);
        for (String s: curr.counts.keySet()) {
            pq.add(new Pair(s, curr.counts.get(s)));
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i<3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().s);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};

        AutocompleteSystem as = new AutocompleteSystem(sentences, times);
        System.out.println(as.input('i'));
        System.out.println(as.input(' '));
        System.out.println(as.input('l'));
        System.out.println(as.input('#'));
    }
}
