package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/** 
 * Algorithm
 * 1. Combine reviews of each hotel. Use the LinkedHashMap because it maintains the order
 * 2. Create an array of keywords
 * 3. Iterate over the HashMap created in the step 1. And count how many word in review matches the keywords. 
 * 4. Create TreeMap of ArrayList and keep the sorting order of the TreeMap as descending.
 * 5. Entry in TreeMap is <count, hotelId>
 * 6. Iterate over the treeMap and combine the ArrayList of Hotels
 */
public class BookingReview4 {

	public static void main(String[] args) {
		String keywords = "breakfast beach citycenter location metro view staff price";

		List<Integer> hotelIds = Arrays.asList(new Integer[] {2,2,1,3,1});

		List<String> reviews = new ArrayList<String>();
		reviews.add("This hotel has a nice view of the citycenter. The location is perfect");
		reviews.add("The is ok. Regarding location, it is quite far from citycenter but price is so cheap so it is worth");
		reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro stationvery close to the hotel.");
		reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
		reviews.add("Very friendly staff and cose-benefit ratio. Its location is bitfar from citycenter.");
		
		long startTime = System.currentTimeMillis();
		List<Integer> ans = processReviews(keywords, hotelIds, reviews);
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println("final : " +ans + "duration : " + duration + "ms");

	}

	private static List<Integer> processReviews(String keys, List<Integer> hotelIds, List<String> reviews) {
		Map<Integer, String> hm = new LinkedHashMap<>();
		Map<String, Integer> keywords = new HashMap<>();
		Map<Integer, ArrayList<Integer>> records = new TreeMap<>(Collections.reverseOrder());
		List<Integer> ans = new ArrayList<>();
		
		for (int i=0; i<hotelIds.size(); i++) {
			int hotelId = hotelIds.get(i);
			hm.put(hotelId, hm.getOrDefault(hotelId, "") + reviews.get(i).replaceAll("[-+.^:,!']", "").toLowerCase() + " ");
		}
		
		String[] words = keys.split(" ");
		for (String word: words) {
			keywords.put(word, 0);
		}

		for (Entry<Integer, String> entry : hm.entrySet()) {
			int count = 0;
			int hotelId = entry.getKey();
			String[] review = entry.getValue().split(" ");
			
			for (String word : review) {
				if (keywords.containsKey(word)) {
					count++;
				}
			}

//			if (count <= 0) {
//				continue;
//			}
			
			ArrayList<Integer> li = records.getOrDefault(count, new ArrayList<>());
			li.add(hotelId);
			records.put(count, li);
			
//			if (records.containsKey(count)) {
//				ArrayList<Integer> list = records.get(count);
//				list.add(hotelId);
//				records.put(count, list);
//			} else {
//				ArrayList<Integer> list = new ArrayList<>();
//				list.add(hotelId);
//				records.put(count, list);
//			}
		}

		records.forEach((k,v) -> {
//			System.out.println(k +" : "+v);
			ans.addAll(v);
		});
		
		return ans;
	}
}