package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HitCounter {
	HashMap<Integer,Integer> hits;
	/** Initialize your data structure here. */
	public HitCounter() {
		this.hits = new HashMap<>();
	}
	public static void main(String[] args) {
		HitCounter counter = new HitCounter();
		counter.hit(1);
		counter.hit(2);
		counter.hit(3);
		int count = counter.getHits(4);
		System.out.println(count);
		counter.hit(300);
		count = counter.getHits(300);
		System.out.println(count);
		count = counter.getHits(301);
		System.out.println(count);
	}

	public void hit(int timestamp) {
		hits.put(timestamp, hits.getOrDefault(timestamp,0)+1);
	}

	public int getHits(int timestamp) {//all time stamps older than 5 mins will be removed, so that the total key size<=300
		int sum = 0;
		Iterator<Map.Entry<Integer,Integer>> entryIterator = hits.entrySet().iterator();
		while(entryIterator.hasNext()){
			Map.Entry<Integer,Integer> entry = entryIterator.next();
			if(timestamp-entry.getKey()>=300) entryIterator.remove();
			else sum += entry.getValue();
		}
		return sum;
	}
}
