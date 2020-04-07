package com.pranay.GeeksForGeeks;

public class StockBuyAndSell {
	public static void main(String[] args) {
		int[] prices = {7,6,4,3,1};
		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);
	}

	private static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int buy = Integer.MAX_VALUE;
		int sell = Integer.MIN_VALUE;
		for (int i = 0; i<prices.length; i++) {
			if (prices[i] < buy) {
				buy = prices[i];
				sell = 0;
			}
			if (prices[i] > sell) {
				sell = prices[i];
			}
			maxProfit = Math.max(maxProfit, sell - buy);
		}
		return maxProfit;
	}
}
