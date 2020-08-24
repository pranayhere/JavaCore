package com.pranay.interview.strings;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceString {
    public static void main(String[] args) {
        String s = "vmokgggqzp";
        int[] indexes = {3,5,1};
        String[] sources = {"kg","ggq","mo"};
        String[] targets = {"s","so","bfr"};

        String ans = findReplaceString(s, indexes, sources, targets);
        System.out.println("Ans : " + ans);
    }

    private static String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (s.startsWith(sources[i], indexes[i]))
                hm.put(indexes[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            if (hm.containsKey(i)) {
                sb.append(targets[hm.get(i)]);
                i += sources[hm.get(i)].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
