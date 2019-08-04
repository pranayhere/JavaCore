package com.pranay.GeeksForGeeks;

public class BooksGS {

	public static void main(String[] args) {
		int totalScore = 6;
		int count = noOfWaysToDrawTheGame(totalScore);
		System.out.println("result : " + result);
	}

	static int result = 0;
	
	static int noOfWaysToDrawTheGame(int totalScore) {
		if (totalScore == 0) {
			return 0;
		}
		calculate(0, totalScore, 0);
		return totalScore; 
    }

	private static void calculate(int sum, int totalScore, int counter) {
		if (sum > totalScore || counter > 10) {
			return;
		}
		System.out.println(sum + " "+ counter);
		if (sum == totalScore) {
			result++;
			System.out.println("Inside : ");
		}
		
		for (int i=2; i<=6; i=i+2) {
			calculate(sum + i, totalScore, counter+1);
		}
	}
}
