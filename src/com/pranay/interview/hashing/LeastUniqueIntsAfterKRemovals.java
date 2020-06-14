package com.pranay.interview.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LeastUniqueIntsAfterKRemovals {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        int leastUnique = findLeastNumOfUniqueInts(arr, k);
        System.out.println("Least unique : " + leastUnique);
    }

    private static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i<arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(hm);

        int maxFreq = Collections.max(hm.values());
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i<=maxFreq; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Integer num: hm.keySet()) {
            int freq = hm.get(num);
            buckets.get(freq).add(num);
        }

        System.out.println(buckets);
        List<Integer> expand = new ArrayList<>();
        for (int i = 1; i < buckets.size(); i++) {
            for (Integer num : buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    expand.add(num);
                }
            }
        }

        System.out.println(expand);
        List<Integer> sublist = expand.subList(k, expand.size());
        System.out.println(sublist);
        Set<Integer> set = new HashSet<>(sublist);
        return set.size();
    }
}
