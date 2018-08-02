package com.pranay.Threads3ordered;

public class ThreeThreadsOrderedLockLess {

	public static class Printer {
		private Integer printNumber;
		private Integer maxCount;
		private Integer currentThread;
		private Integer threadCount;
		private boolean stop = false;

		public Printer(Integer printNumber, Integer maxCount, Integer currentThread, Integer threadCount) {
			super();
			this.printNumber = printNumber;
			this.maxCount = maxCount;
			this.currentThread = currentThread;
			this.threadCount = threadCount;
		}

		public synchronized void print(int threadNumber) throws InterruptedException {
			while (true) {

//				while (!stop && !this.currentThread.equals(threadNumber)) {
//					this.wait(1000);
//				}
//				
				while(!this.currentThread.equals(threadNumber)) {
					this.wait(1000);
				}
				if (stop) {
					this.notifyAll();
					return;
				}
				if (printNumber > maxCount) {
					stop = true;
					return;
				}
				Thread.sleep(100);
				System.out.println(Thread.currentThread().getName() +": "+ printNumber);
				printNumber++;
				currentThread = (currentThread + 1) % threadCount;
				this.notifyAll();
			}
		}
	}

	static class PrinterTask implements Runnable {
		private Printer printer;
		private int task;

		public PrinterTask(Printer printer, int task) {
			super();
			this.printer = printer;
			this.task = task;
		}

		@Override
		public void run() {
			try {
				printer.print(task);
			} catch (InterruptedException e) {
				System.out.println("Stopping: " + Thread.currentThread().getName());
			}
		}
	}

	public static void main(String[] args) {
		Printer printer = new Printer(1, 10, 0, 3);
		PrinterTask task1 = new PrinterTask(printer, 0);
		PrinterTask task2 = new PrinterTask(printer, 1);
		PrinterTask task3 = new PrinterTask(printer, 2);

		new Thread(task1,"Thread 1").start();
		new Thread(task2,"Thread 2").start();
		new Thread(task3,"Thread 3").start();
	}

}