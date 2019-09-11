package com.pranay.GeeksForGeeks;

public class DistanceBetweenBusStops {
	public static void main(String[] args) {
		int[] distance = {7,10,1,12,11,14,5,0};
		int start = 7;
		int destination = 2;
		int ans = distanceBetweenBusStops(distance, start, destination);
		System.out.println("min distance is : " + ans);
	}

	private static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int fwd = 0;
		int rev = 0;

		if (start > destination) {
			return distanceBetweenBusStops(distance, destination, start);
		}

		for(int i = start+1; i<=destination; i++) {
			fwd += distance[i-1];
		}
//		System.out.println(fwd);

		for (int i = destination; i<distance.length; i++) {
			rev += distance[i];
		}

		for (int i = 0; i<start; i++) {
			rev += distance[i];
		}
//		System.out.println(rev);
		return Math.min(fwd, rev);
	}

}
