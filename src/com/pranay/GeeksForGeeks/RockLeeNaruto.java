package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RockLeeNaruto {

	public static void main(String[] args) {
		int n = 10;
		int m = 4;
		int[] spots = {1, 5, 10, 5};
		int mostVisited = mostVisitedSpot(n, m, spots);
		System.out.println(mostVisited);
	}

	static Map<Integer, Integer> tm = new TreeMap<Integer, Integer>();
	
	private static int mostVisitedSpot(int n, int m, int[] spots) {
		for (int i=0; i<m; i++) {
			if (i == 0) {
				addToMap(spots[i]);
				continue;
			}
			
			addToMap(spots[i-1]);
			addToMap(spots[i]);
		}
		
		tm.forEach((k, v) -> System.out.println("k = " +k+ " v = " +v)); // Print TreeMap
		
		int max=tm.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey(); // Get key with maximum value from treemap

		return max;
	}

	private static void addToMap(int key) {
		int count = 1;
		if (tm.containsKey(key)) {
			count = tm.get(key);
			tm.put(key, count++);
		}
		tm.put(key, count);
	}
}


//
//static int max(int a, int b) { return (a > b)? a : b; } 
//

//Integer[] wt = new Integer[bundleQuantities.size()];
//wt = bundleQuantities.toArray(wt);
//
//Integer[] val = new Integer[bundleCosts.size()];
//val = bundleCosts.toArray(val);
//
//int i, w, W = n1;
//int n = bundleQuantities.size();
//
// int K[][] = new int[n+1][W+1]; 
//   
// // Build table K[][] in bottom up manner 
// for (i = 0; i <= n; i++) 
// { 
//     for (w = 0; w <= W; w++) 
//     { 
//         if (i==0 || w==0) 
//              K[i][w] = 0; 
//         else if (wt[i-1] <= w) 
//               K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); 
//         else
//               K[i][w] = K[i-1][w]; 
//     } 
//  } 
//   
//  return K[n][W]; 