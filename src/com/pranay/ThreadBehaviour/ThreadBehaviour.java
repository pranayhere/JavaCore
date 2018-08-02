package com.pranay.ThreadBehaviour;

class Test implements Runnable{
	@Override
	public void run() {
		try {
			if(Thread.currentThread().getName().equals("t1"))
				getData();
			else if(Thread.currentThread().getName().equals("t2"))
				getData2();		// try changing to getData() or getData3()
			else if(Thread.currentThread().getName().equals("t3"))
				getData3();
			else
				getData4();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static synchronized void getData() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " inside static method 1");
		Thread.sleep(5000);
	}
	
	public static synchronized void getData2() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " inside static method 2 ");
		Thread.sleep(5000);
	}
	
	public void getData3() throws InterruptedException {
		synchronized(this) {			//try changing this to Test.class
			System.out.println(Thread.currentThread().getName() + " inside static met 3 ");
			Thread.sleep(5000);
		}
	}
	
	public void getData4() throws InterruptedException {
		synchronized(this) {			//try changing this to Test.class
			System.out.println(Thread.currentThread().getName() + " inside static met 4 ");
			Thread.sleep(5000);
		}
	}
}
class ThreadBehaviour {
	public static void main(String[] args) {
		Test test = new Test();
		Test test2 = new Test();

		Thread t1 = new Thread(test, "t1");
		Thread t2 = new Thread(test2, "t2");	//try changing to test2
		Thread t3 = new Thread(test, "t3");
		Thread t4 = new Thread(test2, "t4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}