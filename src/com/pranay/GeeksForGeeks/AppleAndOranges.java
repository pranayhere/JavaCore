package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class AppleAndOranges {

	public static void main(String[] args) {
		
	}

	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        long appleCount = Arrays.stream(apples)
        	.filter(x -> x + a  >= s && x + a <= t)
        	.count();

        long orangeCount = Arrays.stream(oranges)
        	.filter(x -> x + b  >= s && x + b <= t)
        	.count();

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
