package com.pranay.GeeksForGeeks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BookingReview3 {

	public static void main(String[] args) {
		String keywords = "breakfast beach citycenter location metro view staff price";

		int[] hotelIds = { 2,2,1,2,1};

		List<String> reviews = new ArrayList<String>();
		reviews.add("This hotel has a nice view of the citycenter. The location is perfect");
		reviews.add(
				"The is ok. Regarding location, it is quite far from citycenter but price is so cheap so it is worth");
		reviews.add(
				"Location is excellent, 5 minutes from citycenter. There is also a metro stationvery close to the hotel.");
		reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("Very friendly staff and cose-benefit ratio. Its location is bitfar from citycenter.");
		
		long startTime = System.currentTimeMillis();
		List<Integer> ans = processReviews(keywords, hotelIds, reviews);
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("final : " +ans + "duration : " + duration + "ms");
	}

	private static List<Integer> processReviews(String keys, int[] hotelIds, List<String> reviews) {
		String[] words = keys.split(" ");
		Map<String, Integer> keywords = new HashMap<>();
		Map<Integer, Integer> hotelKeywordCount = new LinkedHashMap<Integer, Integer>();

		for(String word: words) {
			keywords.put(word, 0);
		}
//		System.out.println("All Keywords : " + keywords);

		for (int i = 0; i < hotelIds.length; i++) {
			int count = 0;
			int hotelId = hotelIds[i];
			String[] review = reviews.get(i).replaceAll("[-+.^:,!']", "").toLowerCase().split(" ");
//			System.out.println("Processing for hotelId : " + hotelId);
			
//			for (String string : review) {
//				System.out.print(string + " ");
//			}
//			System.out.println();
			
			for (String word : review) {
				if (keywords.containsKey(word)) {
//					System.out.println(hotelId + " " + word);
					count++;
				}
			}

			hotelKeywordCount.put(hotelId, hotelKeywordCount.getOrDefault(hotelId, 0) + count);
		}

//		System.out.println("Hatels id with keyword count : " + hotelKeywordCount);

		Map<Integer, Integer> sorted = hotelKeywordCount.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(java.util.stream.Collectors.toMap(java.util.Map.Entry::getKey, java.util.Map.Entry::getValue,
						(e1, e2) -> e2, LinkedHashMap::new));

		System.out.println("Sorted Based on keys : " + sorted);
		List<Integer> finalAns = sorted.keySet().stream().collect(Collectors.toList());
		return finalAns;
	}
}