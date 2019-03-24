package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FraudDetectionMedian {

	public static void main(String[] args) {
		int d = 5;
		int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
		
		int count = activityNotifications(expenditure, d);
		System.out.println(count);
	}

	private static int activityNotifications(int[] expenditure, int d) {
		int count = 0;
		for (int i=0; i<expenditure.length; i++) {
			if (i+d > expenditure.length - 1) {
				break;
			}
			int[] sublist = Arrays.copyOfRange(expenditure, i, i+d);
			
			for (int j : sublist) {
				System.out.print(j);
			}
			
			double median = findMedian(sublist, d);

			if (expenditure[i+d] >= 2 * median) {
				count++;
			}
			System.out.println(" median : " + median + " ele : " + expenditure[i+d] + " count : " +count);

		}

		return count;
	}

	public static double findMedian(int a[], int n) 
    { 
        Arrays.sort(a); 
        if (n % 2 != 0) 
        	return (double)a[n / 2]; 
        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0; 
    } 
}
