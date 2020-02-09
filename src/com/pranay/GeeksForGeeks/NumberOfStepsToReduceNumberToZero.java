package com.pranay.GeeksForGeeks;

public class NumberOfStepsToReduceNumberToZero {
	public static void main(String[] args) {
		int num = 123;
		int steps = numberOfSteps(num);
		System.out.println(steps);
	}

	private static int numberOfSteps(int num) {
		int count = 0;
		while (num > 0) {
			if (num % 2 == 1) {
				num--;
				count++;
			} else {
				num = num/2;
				count++;
			}
		}
		return count;
	}


}
