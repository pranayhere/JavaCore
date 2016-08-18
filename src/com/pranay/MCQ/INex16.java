package com.pranay.MCQ;

public class INex16 implements Runnable {

	public static void main(String[] args) {
		Thread t = new Thread(new INex16());
		t.start();
		System.out.println("m1 ");
		try {
			t.join();
		}
		catch(Exception e) {
		}
		System.out.println("m2 ");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("r1 ");
		System.out.println("r2 ");
		
	}
}
