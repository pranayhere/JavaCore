package com.pranay.MCQ;

enum Rating {
	AVERAGE {
		@Override
		String performance() {
			// TODO Auto-generated method stub
			return "here1";
		}
	}, 
	GOOD {
		@Override
		String performance() {
			// TODO Auto-generated method stub
			return "here2";
		}
	}, 
	EXCELLENT {
		@Override
		String performance() {
			// TODO Auto-generated method stub
			return "here3";
		}
	};
	
	abstract String performance();
}
public class Example16 {
	public static void main(String[] args) {
		System.out.println(Rating.AVERAGE.performance());
	}
}
