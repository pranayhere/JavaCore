package com.pranay.hashtable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyHashtable {
	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("first", "pranay");
		ht.put("second", "rahul");
		ht.put("third", "ruju");
		System.out.println(ht);
		
		System.out.println("Value for key second is : "+ht.get("second"));
		System.out.println("Is Hashtable empty : "+ht.isEmpty());
		System.out.println("Size of hashtable : "+ht.size());
		
		Set<String> keys = ht.keySet();
		for(String key : keys) {
			System.out.println("Value of "+key+" is :"+ht.get(key));
		}
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("s1", "s1 value");
		hm.put("s2", "s2 value");
		ht.putAll(hm);
		System.out.println(ht);
		
		System.out.println("ht contains key : "+ht.containsKey("second"));
		System.out.println("ht contains value : "+ht.containsValue("rujuta"));
		
		
	}
}
