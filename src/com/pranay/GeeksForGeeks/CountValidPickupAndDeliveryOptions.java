package com.pranay.GeeksForGeeks;

/**
 * Case: n = 1
 * Result: 1 (P1 D1)
 *
 * Case: n = 2
 * Place P2 D2 to 1 result from case n=1: (__ P1 __ D1 __), there are 3 spaces to place to
 * The result will be:
 * (P2 D2 P1 D1) (P2 P1 D2 D1) (P2 P1 D1 D2)
 * (P1 P2 D2 D1) (P1 P2 D1 D2)
 * (P1 D1 P2 D2)
 *
 * We can come up with the formula
 *
 * spaceNum = (n-1)*2 + 1
 * result = 1 + 2 + ... + spaceNum = spaceNum * (spaceNum+1) / 2
 * Hence,
 *
 * spaceNum = (n-1)*2 + 1 = 3
 * result = spaceNum * (spaceNum+1) / 2 = 3 * 4 / 2 = 6
 * Result: 6
 *
 * Case: n = 3
 * Place P3 D3 to 6 results from case n=2: (__ P2 __ D2 __ P1 __ D1 __), (__ P2 __ P1 __ D2 __ D1 __),..., (__ P1 __ D1 __ P2 __ D2 __)
 * Hence,
 *
 * spaceNum = (n-1)*2 + 1 = 5
 * result = spaceNum * (spaceNum+1) / 2 = 5 * 6 / 2 = 15
 * // Apply this P3 D3 place to 6 results from case n = 2
 * // result = 15 * 6 = 90
 * Result: 90
 */
public class CountValidPickupAndDeliveryOptions {
	public static void main(String[] args) {
		int n = 2;
		int count = countOrders(n);
		System.out.println(count);
	}

	private static int countOrders(int n) {
		long MODULO = (long) (1e9 + 7);
		long ans = 1;
		for (int i = 2; i <= n; i++) {
			int spaceNum = (i-1)*2 + 1;
			ans *= spaceNum * (spaceNum + 1) / 2;
			ans %= MODULO;
		}
		return (int) ans;
	}
}
