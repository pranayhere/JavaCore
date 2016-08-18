package com.pranay.ThreadStopDemo;

import java.util.concurrent.TimeUnit;

public class ThreadStopDemo {
	public static void main(String[] args) throws InterruptedException {
		Server server = new Server();
		Thread t = new Thread(server, "t1");
		t.start();
		Thread.sleep(100);
		server.stopThread();
		TimeUnit.MILLISECONDS.sleep(200);
	}
}

class Server implements Runnable {
	private volatile boolean isExit = false;
	private int i = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!isExit) {
			i++;
			System.out.println("Thread is running"+i);
		}
		System.out.println("Server is stopped....");
	}
	
	public void stopThread() {
		isExit = true;
	}
}