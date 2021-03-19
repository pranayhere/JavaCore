package com.pranay.interview.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/
 */

public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> count;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        count = new HashMap<>();
        lists = new HashMap<>();
    }

    public int get(int key) {
        if (!vals.containsKey(key))
            return -1;

        int cnt = count.get(key);
        count.put(key, cnt + 1);
        lists.get(cnt).remove(key);

        if (cnt == min && lists.get(cnt).size() == 0)
            min = cnt + 1;

        lists.computeIfAbsent(cnt + 1, k -> new LinkedHashSet<>()).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0)
            return;

        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }

        if (vals.size() >= cap) {
            int evict = lists.get(min).iterator().next();
            vals.remove(evict);
            count.remove(evict);
            lists.get(min).remove(evict);
        }

        vals.put(key, value);
        count.put(key, 1);
        lists.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        min = 1;
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
    }
}
