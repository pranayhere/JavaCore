package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> partitions = partitionLabels(s);
        System.out.println(partitions);
    }

    private static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastOccr = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccr.put(s.charAt(i), i);
        }
        System.out.println(lastOccr);

        int j = 0;
        int anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i<s.length(); i++) {
            j = Math.max(j, lastOccr.get(s.charAt(i)));
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
