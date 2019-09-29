package com.pranay.GeeksForGeeks;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicates2 {
	public static void main(String[] args) {
		String s = "pbbcggttciiippooaais";
		int k = 2;
		System.out.println(removeDuplicates(s, k));
	}

	public static String removeDuplicates(String s, int k) {
		Map<String, Integer> hm = new LinkedHashMap<>();
		for (String ch: s.split("")) {
			hm.put(ch, hm.getOrDefault(ch, 0) + 1);
		}

		hm.forEach((key, v) -> System.out.println(key + " " +v));

		String ans = "";

		for(Map.Entry<String, Integer> entry: hm.entrySet()) {
			if (entry.getValue() % k == 0) {
				continue;
			} else {
				if (entry.getValue() < k) {
					for (int i = 0; i<entry.getValue(); i++)
						ans += entry.getKey();
				}
				else {
					int count = entry.getValue() % k;
					for (int i = 0; i<count; i++)
						ans += entry.getKey();
				}
			}
		}
		return ans;
	}
}
