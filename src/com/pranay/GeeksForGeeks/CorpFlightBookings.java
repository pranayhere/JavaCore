package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class CorpFlightBookings {

	public static void main(String[] args) {
		int[][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
		int n = 5;
		corpFlightBookings2(bookings, n);
	}

	private static void corpFlightBookings(int[][] bookings, int n) {
		int[] seats = new int[n];
 		for (int p=0; p<bookings.length; p++) {
			int i = bookings[p][0]-1;
			int j = bookings[p][1]-1;
			int k = bookings[p][2];

			for (int q = i; q<=j; q++) {
				seats[q] = seats[q] + k;
			}
			System.out.println(Arrays.toString(seats));
		}

		System.out.println("final : " +Arrays.toString(seats));
	}

	
	private static void corpFlightBookings2(int[][] bookings, int n) {
		int[] res = new int[n];
 		for (int[] b: bookings) {
 			res[b[0]-1] += b[2];
 			if (b[1] < n) res[b[1]] -= b[2];
 			System.out.println(Arrays.toString(res));
 		}
// 		System.out.println(Arrays.toString(res));
 		for (int i = 1; i < n; ++i)
            res[i] += res[i - 1];
 		System.out.println("final : " + Arrays.toString(res));
	}
}
