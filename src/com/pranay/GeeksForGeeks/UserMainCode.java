package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UserMainCode {
	public static void main(String[] args) {
		String input1  = "AbcDef";
		int input2 = 1;
		int input3 = 2;
		
		int turns = totalTurns(input1, input2, input3);
	}

	private static int totalTurns(String input1, int input2, int input3) {
		String original = input1;
		final int[] arr = Stream.of(input1.split(""))
				.mapToInt(Integer::parseInt)
				.toArray();

		return 0;
	}
}