package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	public static void main(String[] args) {
		List<Integer> bundleQuantities = new ArrayList<Integer>();
		bundleQuantities.add(10);
		//bundleQuantities.add(19);
		
		List<Integer> bundleCosts = new ArrayList<Integer>();
		bundleCosts.add(2);
//		bundleCosts.add(20);
		
		int n = 4;
		
		int ans = budgetShopping(n, bundleQuantities, bundleCosts);
		System.out.println(ans);
	}

	public static int budgetShopping(int n1, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
		int ansQty = 0;
		int amtRemaining = n1;
		while(amtRemaining >= 0)
		{
			float min = Float.MAX_VALUE;
			int minIndex = -1;
			for(int i = 0; i< bundleQuantities.size();i++) {
				float current = (float)bundleQuantities.get(i)/(float)bundleCosts.get(i) ;
				if(current < min) {
					min = current;
					minIndex = i;
					}
			}
			if(bundleCosts.size() == 0) {
				break;
			}
			int noOfQty = amtRemaining/bundleCosts.get(minIndex);
			
			ansQty += noOfQty * bundleQuantities.get(minIndex);
			amtRemaining -= bundleCosts.get(minIndex) * noOfQty;
			bundleQuantities.remove(minIndex);
			bundleCosts.remove(minIndex);
		}
		return ansQty;
	}
}
