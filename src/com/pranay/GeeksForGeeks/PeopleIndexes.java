package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PeopleIndexes {
    public static void main(String[] args) {
        List<List<String>> fc = new ArrayList<>();
        fc.add(Arrays.asList("leetcode","google","facebook"));
        fc.add(Arrays.asList("google","microsoft"));
        fc.add(Arrays.asList("google","facebook"));
        fc.add(Arrays.asList("google"));
        fc.add(Arrays.asList("amazon"));
        List<Integer> ans = peopleIndexes(fc);
        System.out.println(ans);
    }

    private static List<Integer> peopleIndexes(List<List<String>> fc) {
        Map<Integer, Set<String>> hm = new HashMap<>();
        int len = fc.size();
        for (int i = 0; i<len; i++) {
            Set<String> set = new HashSet<>(fc.get(i));
            hm.put(i, set);
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i< len; i++) {
            for (int j = i+1; j<len; j++) {
                Set<String> out = hm.get(i);
                Set<String> inner = hm.get(j);
                if (out.size() >= inner.size()) {
                    if (out.containsAll(inner)) {
                        set.add(j);
                    }
                } else {
                    if (inner.containsAll(out)) {
                        set.add(i);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList();
        for(int i = 0; i < len; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}