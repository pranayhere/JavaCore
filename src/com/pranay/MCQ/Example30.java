package com.pranay.MCQ;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Example30 {
	public static void main(String[] args) {
		String a = "A";
		
		Map<String, Object> map1 = new ConcurrentHashMap<String, Object>();
		map1.put(a, a);
		map1.put("B", "B");
		
		Map<String, Object> map2 = new ConcurrentHashMap<String, Object>();
		map2.put("A", "A");
		map2.put("B", "B");
		
		Map<String, Object> map3 = new ConcurrentHashMap<String, Object>();
		map3.put("B", "B");
		map3.put("A", "A");
		
		Map<Object, Object> map4 = new ConcurrentHashMap<Object, Object>();
		map4.put("A", "A");
		map4.put("B", "B");
		
		System.out.println(map1.equals(map2));
		System.out.println(map2.equals(map3));
		System.out.println(map3.equals(map4));
		System.out.println(map1.equals(map4));
	}
}
