package com.pranay.interview.arrays;

/**
 * Given a binary String which represents the target state.
 * Minimum number of flips needed to convert a same size Binary String (with all 0’s)  to target state.
 * A flip also causes all the right bits to be flipped.
 *
 * Input : 00101 (Represents Target)
 * Output : 3
 * Explanation: 00000 -> 00111 -> 00100 -> 00101
 */

public class FlipBits {
	public static void main(String[] args) {
		String target = "00101";
		int count = minFlips(target);
		System.out.println(count);
	}

	private static int minFlips(String target) {

		return 0;
	}
}
