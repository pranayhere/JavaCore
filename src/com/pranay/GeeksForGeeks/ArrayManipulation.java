package com.pranay.GeeksForGeeks;

public class ArrayManipulation {
	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		int[][] queries = {
				{1, 2, 100},
				{2, 5, 100},
				{3, 4, 100}
		};
		
		int maxValue = arrayManipulation(n, queries);
		System.out.println(maxValue);
	}

	private static int arrayManipulation(int n, int[][] queries) {
		long arr[] = new long[n];

        // each successive element contains the difference between itself and previous element
        for (int i = 0; i < queries.length; i++) {
	        // when checking query, subtract 1 from both a and b since 0 indexed array
	        int a = queries[i][0] - 1;
	        int b = queries[i][1] - 1;
	        int k = queries[i][2];
	
	        arr[a] += k;
	        if (b+1 < n) {
	        	arr[b+1] -= k;  
	        }
	        
	        for(long j : arr)
	        	System.out.print(j + " ");
	        System.out.println();
        }

        // track highest val seen so far as we go
        long max = Long.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
	        arr[i] += arr[i-1];
	        max = Math.max(arr[i], max);
        }

        return (int) max;
	}
}
