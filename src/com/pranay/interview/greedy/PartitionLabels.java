package com.pranay.interview.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> partitions = partitionLabels(S);
        System.out.println(partitions);
    }

    private static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        System.out.println(Arrays.toString(last));

        int j = 0, anchor = 0;
        List<Integer> res = new ArrayList<>();
        
        return null;
    }


}
