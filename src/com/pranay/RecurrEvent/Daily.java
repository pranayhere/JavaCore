package com.pranay.RecurrEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Daily {
	public static void main(String[] args) {
		int interval = 2;
		LocalDate localDate = LocalDate.now();
		LocalDate next = nextOccurrence(localDate, interval);
		System.out.println(next);
		List<LocalDate> nextK = nextKOccurrence(localDate, interval, 10);
		System.out.println(nextK);
	}

	private static List<LocalDate> nextKOccurrence(LocalDate localDate, int interval, int k) {
		List<LocalDate> dates = new ArrayList<>();
		for (int i = 0; i<k; i++) {
			dates.add(localDate.plusDays(interval));
			localDate = localDate.plusDays(interval + 1);
		}
		return dates;
	}

	private static LocalDate nextOccurrence(LocalDate localDate, int interval) {
		return localDate.plusDays(interval);
	}


}
