package com.pranay.GeeksForGeeks;

public class minimumBribes {
	public static void main(String[] args) {
		int[] q = {2, 1, 5, 3, 4};
		int count = minimumBribes(q);
		System.out.println(count);
	}

	private static int minimumBribes(int[] q) {
		for (int i=0; i<q.length; i++) {
			if((q[i] - (i+1)) > 2) {
				System.out.println("Too chaotic");
			}
		}
		
		int swaps = 0;
		for (int i=0; i<q.length-1; i++) {
			for (int j=i+1; j<i+2; j++) {
				if (q[i] > q[j]) {
					int tmp=q[j];
                    q[j]=q[i];
                    q[i]=tmp;
                    swaps++;
				}
			}
		}

		return swaps;
	}
}
