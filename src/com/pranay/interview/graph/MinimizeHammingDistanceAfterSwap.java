package com.pranay.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UF {
    int[] parent;

    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        return parent[x] = parent[x] == x ? x : find(parent[x]);
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

public class MinimizeHammingDistanceAfterSwap {
    public static void main(String[] args) {
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = {{0, 1}, {2, 3}};

        int dist = minimumHammingDistance(source, target, allowedSwaps);
        System.out.println("Distance : " + dist);
    }

    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int res = 0;
        UF uf = new UF(n);
        Set<Integer> valid = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> cntMap = new HashMap<>();
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
            valid.add(swap[0]);
            valid.add(swap[1]);
        }
        for (int indice : valid) {
            int rep = uf.find(indice);
            cntMap.putIfAbsent(rep, new HashMap<>());
            Map<Integer, Integer> cnt = cntMap.get(rep);
            cnt.merge(source[indice], 1, Integer::sum);
        }
        for (int i = 0; i < n; i++) {
            if (valid.contains(i)) {
                int rep = uf.find(i);
                Map<Integer, Integer> cnt = cntMap.get(rep);
                if (cnt.containsKey(target[i])) {
                    cnt.put(target[i], cnt.get(target[i]) - 1);
                    if (cnt.get(target[i]) == 0) {
                        cnt.remove(target[i]);
                    }
                } else {
                    res++;
                }
            } else {
                res += source[i] == target[i] ? 0 : 1;
            }
        }
        return res;
    }
}