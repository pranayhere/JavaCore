package com.pranay.MCQ;

class Runner implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=3; i++) {
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
}

public class INex8 {
	public static void main(String[] args) {
		Runner r = new Runner();
		Thread t1 = new Thread(r, "Thread A");
		Thread t2 = new Thread(r, "Thread B");
		t1.start();
		t2.start();
	}
}
