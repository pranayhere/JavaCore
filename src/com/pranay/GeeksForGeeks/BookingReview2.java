package com.pranay.GeeksForGeeks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BookingReview2 {
	// Complete the sort_hotels function below.
	static List<Integer> sort_hotels(String keys, List<Integer> hotelIds, List<String> reviews) {
		String[] words = keys.split(" ");
		Map<String, Integer> keywords = new LinkedHashMap<String, Integer>();
		Map<Integer, Integer> hotelKeywordCount = new HashMap<Integer, Integer>();

		for (String word : words) {
			keywords.put(word, 0);
		}

		System.out.println("All Keywords : " + keywords);

		for (int i = 0; i < hotelIds.size(); i++) {
			int count = 0;
			int hotelId = hotelIds.get(i);
			String[] review = reviews.get(i).replaceAll("[-+.^:,!']", "").toLowerCase().split(" ");
			for (String word : review) {
				if (keywords.containsKey(word)) {
					System.out.println(hotelId + " " + word);
					count++;
				}
			}

			if (hotelKeywordCount.containsKey(hotelId)) {
				hotelKeywordCount.put(hotelId, hotelKeywordCount.get(hotelId) + count);
			} else {
				hotelKeywordCount.put(hotelId, count);
			}
		}

		TreeMap<Integer, Integer> sorted = (TreeMap<Integer, Integer>) sortByValue(hotelKeywordCount);

		System.out.println("Sorted Based on keys : " + sorted);

		System.out.println("Sorted : " + sorted);
		List<Integer> finalAns = sorted.keySet().stream().collect(Collectors.toList());
		return finalAns;

	}
	
	public static Map sortByValue(Map unsortedMap) {
		Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}

	public static void main(String[] args) throws IOException {
		String keywords = "breakfast beach citycenter location metro view staff price";

		List<Integer> hotelIds = new ArrayList<Integer>();
		hotelIds.add(1);
		hotelIds.add(1);
		hotelIds.add(1);
		hotelIds.add(1);
		hotelIds.add(2);

		List<String> reviews = new ArrayList<String>();
		reviews.add("This hotel has a nice view of the citycenter. The location is perfect");
		reviews.add(
				"The breakfast is ok. Regarding location, it is quite far from citycenter but price is so cheap so it is worth");
		reviews.add(
				"Location is excellent, 5 minutes from citycenter. There is also a metro stationvery close to the hotel.");
		reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("Very friendly staff and cose-benefit ratio. Its location is bitfar from citycenter.");

		List<Integer> ans = sort_hotels(keywords, hotelIds, reviews);
		System.out.println(ans);
	}
}

class ValueComparator implements Comparator {
	Map map;
 
	public ValueComparator(Map map) {
		this.map = map;
	}
 
	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueB.compareTo(valueA);
	}
}