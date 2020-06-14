package com.pranay.interview.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

public class LeastUniqueIntsAfterKRemovals {
    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        int leastUnique = findLeastNumOfUniqueIntsPriorityQueue(arr, k);
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

    private static int findLeastNumOfUniqueIntsPriorityQueue(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, count.getOrDefault(a, 0) + 1);

//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(count::get)); // hashmap to priorityqueue pq
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        pq.addAll(count.keySet());

        while (k > 0)
            k -= count.get(pq.poll());

        return k < 0 ? pq.size() + 1 : pq.size();
    }
}
