package com.pranay.GeeksForGeeks;

public class ActivitySelection {

	public static void main(String[] args) {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 6, 7, 9, 9 };
		printMaxActivities(start, end);
	}

	private static void printMaxActivities(int[] s, int[] f) {
		int i, j;
		int n = s.length;
		System.out.print("Following activities are selected : n");

		// The first activity always gets selected
		i = 0;
		System.out.print(i + " ");

		for (j = 1; j < n; j++) {
			if (s[j] >= f[i]) {
				System.out.print(j + " ");
				i = j;
			}
		}
	}

}
