package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
	Map<Integer, String> station;
	Map<Integer, Integer> time;
	Map<String, Integer> travelCount;
	Map<String, Long> travelTime;

	public UndergroundSystem() {
		station = new HashMap<>();
		time = new HashMap<>();
		travelCount = new HashMap<>();
		travelTime = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		station.put(id, stationName);
		time.put(id, t);
	}

	public void checkOut(int id, String stationName, int t) {
		String code = station.get(id) + "-" + stationName;
		travelCount.put(code, travelCount.getOrDefault(code, 0) + 1);
		station.remove(id);

		Integer totalTime = t - time.get(id);
		travelTime.put(code, travelTime.getOrDefault(code, 0L) + totalTime);
		time.remove(id);
	}

	public double getAverageTime(String startStation, String endStation) {
		String code = startStation +"-"+endStation;
		Integer count = travelCount.get(code);
		Long time = travelTime.get(code);

		double avgTime = time / count;
		return avgTime;
	}

	public static void main(String[] args) {
		UndergroundSystem undergroundSystem = new UndergroundSystem();
		undergroundSystem.checkIn(45, "Leyton", 3);
		undergroundSystem.checkIn(32, "Paradise", 8);
		undergroundSystem.checkIn(27, "Leyton", 10);
		undergroundSystem.checkOut(45, "Waterloo", 15);
		undergroundSystem.checkOut(27, "Waterloo", 20);
		undergroundSystem.checkOut(32, "Cambridge", 22);
		System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.0. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.0
		undergroundSystem.checkIn(10, "Leyton", 24);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.0
		undergroundSystem.checkOut(10, "Waterloo", 38);
		System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 12.0
	}

}
