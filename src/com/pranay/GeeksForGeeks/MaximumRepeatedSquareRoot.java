package com.pranay.GeeksForGeeks;

//import math
//
//def solution(A, B):
//    if (B <= A):
//        return 0
//
//    count = 0
//    a = math.ceil(math.sqrt(A))
//    b = math.floor(math.sqrt(B))
//    while (b >= a):
//        a = math.ceil(math.sqrt(a))
//        b = math.floor(math.sqrt(b))
//        count = count + 1
//    return count

public class MaximumRepeatedSquareRoot {

	public static void main(String[] args) {
		int a = 2;
		int b = 100000000;
		int count = maxRepeatedSqrt(a, b);
		System.out.println(count);
	}

	private static int maxRepeatedSqrt(double a, double b) {
		int count = 0;
		a = Math.ceil(Math.sqrt(a));
		b = Math.floor(Math.sqrt(b));
		
		while (b>= a) {
			a = Math.ceil(Math.sqrt(a));
			b = Math.floor(Math.sqrt(b));
			count++;
		}
		return count;
	}

}
