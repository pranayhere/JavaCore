package com.pranay.interview.hashing;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer, Integer> hm;
    int capacity;

	public LRUCache (int capacity) {
	    hm = new LinkedHashMap<>();
	    this.capacity = capacity;
	}

	public int get(int k) {
		int val = -1;
	    if (hm.containsKey(k)) {
		    val = hm.get(k);
		    hm.remove(k);
		    hm.put(k, val);
        }
	    return val;
	}

	public void put(int k, int v) {
	    if (!hm.containsKey(k) && hm.size() == capacity) {
	        hm.remove(hm.keySet().iterator().next());
	        hm.put(k, v);
        } else if (hm.containsKey(k)) {
	        hm.remove(k);
	        hm.put(k, v);
        } else {
	        hm.put(k, v);
        }
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}
}
