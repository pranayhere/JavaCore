package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	public static void main(String[] args) {
//		String[] magazine = {"give", "me", "one", "grand", "today", "night"};
//		String[] note = {"give", "one", "grand", "today"};
//		
		String[] magazine = {"two", "times", "three", "is", "not", "four"};
		String[] note = {"two", "times", "two", "is", "four"};
		
		String matches = checkMagazine(magazine, note);
		System.out.println(matches);
	}

	private static String checkMagazine(String[] magazine, String[] note) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for (String str: magazine) {
			int count = 1;
			if (hm.containsKey(str)) {
				count = hm.get(str);
				hm.put(str, count++);
			}
			hm.put(str, count);
		}
				
		for (String str : note) {
			hm.forEach((k,v) -> System.out.println("k="+k+" v="+v));
			int count = 0;
			if (hm.containsKey(str)) {
				count = hm.get(str);
			}
			
			if (count == 0)
				return "No";

			hm.put(str, --count);
			System.out.println("---------------------------");
		}
		
		return "Yes";
	}
}
