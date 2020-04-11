package com.pranay.RecurrEvent;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Monthly {
	public static void main(String[] args) {
		int interval = 2;

		LocalDate day = LocalDate.now();

		LocalDate next = nextOccurrence(day, interval);
		System.out.println(next);
	}

	private static LocalDate nextOccurrence(LocalDate day, int interval) {
		return day.plusMonths(interval + 1);
	}
}
