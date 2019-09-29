package com.pranay.GeeksForGeeks;

import com.pranay.CombinedCollections.HashMap_ArrayList_Demo;

import java.util.HashMap;
import java.util.Map;

public class MaxNoOfBalloons {
	public static void main(String[] args) {
		String t = "loonbalxballpoon";
		int ans = maxNumberOfBalloons2(t);
		System.out.println(ans);
	}

	private static int maxNumberOfBalloons(String text) {
		String[] t = text.split("");
		Map<String, Integer> hm = new HashMap<>();
		for (String s: t) {
			hm.put(s, hm.getOrDefault(s, 0) + 1);
		}
		hm.forEach((k, v) -> System.out.println(k+ " : " +v));

		boolean isBalloonPresent;
		int count = 0;
		while (!hm.isEmpty()) {
			if (checkBalloon(hm, "balloon")) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}

	private static boolean checkBalloon(Map<String, Integer> hm, String balloon) {
		for (String s: balloon.split("")) {
			if (hm.containsKey(s)) {
				int count = hm.get(s);
				count--;
				if (count == 0) {
					hm.remove(s);
				} else {
					hm.put(s, count);
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public static int maxNumberOfBalloons2(String text) {
		if (text == null || text.length() < 7)
			return 0;
		int[] c = new int[26];
		for (char ch : text.toCharArray())
			c[ch - 'a']++;
		int res = Integer.MAX_VALUE;
		res = Math.min(res, c['b' - 'a']);
		res = Math.min(res, c['a' - 'a']);
		res = Math.min(res, c['l' - 'a'] / 2);
		res = Math.min(res, c['o' - 'a'] / 2);
		res = Math.min(res, c['n' - 'a']);
		return res;
	}
}
