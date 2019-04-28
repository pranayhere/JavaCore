package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class MakeAnagramString {

	public static void main(String[] args) {
		String a = "fcrxzwscanmligyxyvym";
		String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
		
		int count = makeAnagrams(a, b);
		System.out.println(count);
	}

	static Map<Character, Integer> hm = new HashMap<Character, Integer>();
	
//	private static int makeAnagrams(String a, String b) {
//		int count = 0;
//
//		for(int i=0; i<a.length(); i++) {
//			addToMap(a.charAt(i));
//		}
////		hm.forEach((k, v) -> System.out.println(k+ " " +v)); // Print HashMap
//		
//		for (int i=0; i<b.length(); i++) {
//			if (hm.containsKey(b.charAt(i))) {
//				removeFromMap(b.charAt(i));
//			} else {
//				count++;
//			}
//		}
////		hm.forEach((k, v) -> System.out.println(k+ " " +v)); // Print HashMap
//		
//		for (Integer value : hm.values()) {
//		    count += value;
//		}
//		
//		return count;
//	}
	
	private static int makeAnagrams(String first, String second) {
		int[] lettercounts = new int[26];
		for(char c : first.toCharArray()){
			lettercounts[c-'a']++;
		}
		for(char c : second.toCharArray()){
			lettercounts[c-'a']--;
		}
		int result = 0;
		for(int i : lettercounts){
			result += Math.abs(i);
		}
		
		return result;
	}

//	private static void addToMap(Character key) {
//		int count = 1;
//		if (hm.containsKey(key)) {
//			count = hm.get(key);
//			hm.put(key, ++count);
//			return;
//		}
//		hm.put(key, count);
//	}
//	
//	private static void removeFromMap(Character key) {
//		if (hm.containsKey(key)) {
//			int count = hm.get(key);
//			count--;
//			if (count == 0) {
//				hm.remove(key);	
//				return;
//			}
//			hm.put(key, count);
//		}
//		System.out.println();
//	}
}
