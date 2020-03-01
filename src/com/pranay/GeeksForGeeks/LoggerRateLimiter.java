package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/logger-rate-limiter/
 * 359. Logger Rate Limiter
 */

public class LoggerRateLimiter {
	Map<String, Integer> hm;
	public LoggerRateLimiter() {
		hm = new HashMap<>();
	}

	public static void main(String[] args) {
		LoggerRateLimiter logger = new LoggerRateLimiter();
		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(2,"bar"));
		System.out.println(logger.shouldPrintMessage(3,"foo"));
		System.out.println(logger.shouldPrintMessage(8,"bar"));
		System.out.println(logger.shouldPrintMessage(10,"foo"));
		System.out.println(logger.shouldPrintMessage(11,"foo"));
	}

	private boolean shouldPrintMessage(int i, String str) {
		if (hm.containsKey(str) && hm.get(str) > i - 10) {
			return false;
		}
		hm.put(str, i);
		return true;
	}
}
