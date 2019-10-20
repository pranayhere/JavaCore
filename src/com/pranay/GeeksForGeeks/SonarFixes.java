package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class SonarFixes {
	public static void main(String[] args) {
		Map<String, Integer> data = new HashMap<String, Integer>(){{
			put("latestVersion", 1);
		}};

		Map<String, Integer> data1 = new HashMap<>();
		data1.put("latestVersion", 1);
		System.out.println(data1.get("latestVersion"));
	}
}
