package com.pranay.ReenterentLockCustom;

interface LockCustom {
	void lock();
	void unlock();
	boolean tryLock();
}

class ReentrantLockCustom implements LockCustom {
	int lockHoldCount;
	long idOfThreadHoldinglock;

	public ReentrantLockCustom() {
		lockHoldCount = 0;
	}

	@Override
	public synchronized void lock() {
		if(lockHoldCount == 0) {
			lockHoldCount++;
			idOfThreadHoldinglock = Thread.currentThread().getId();
		}
		else if(lockHoldCount > 0 && idOfThreadHoldinglock == Thread.currentThread().getId()) {
			lockHoldCount++;
		}
		//If the lock is held by another thread then the current
		// thread waits for another thread to release lock.
		else {
			try {
				this.wait();
				lockHoldCount++;
				idOfThreadHoldinglock = Thread.currentThread().getId();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public synchronized void unlock() {
		if(lockHoldCount == 0)
			throw new IllegalMonitorStateException();
		lockHoldCount--;
		if(lockHoldCount == 0)
			notify();
	}

	@Override
	public synchronized boolean tryLock() {
		if(lockHoldCount == 0) {
			lock();
			return true;
		}
		else
			return false;
	}

}

public class ReenterentLockCustomTest {
	public static void main(String[] args) {
		LockCustom lock = new ReentrantLockCustom();
		MyRunnable myRunnable = new MyRunnable(lock);
		new Thread(myRunnable, "Thread-1").start();
		new Thread(myRunnable, "Thread-2").start();
	}
}

class MyRunnable implements Runnable {
	LockCustom lockCustom;

	public MyRunnable(LockCustom lockCustom) {
		this.lockCustom = lockCustom;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName()
				+" is Waiting to acquire LockCustom");

		lockCustom.lock();
		System.out.println(Thread.currentThread().getName()
				+" has acquired LockCustom.");

		try {
			System.out.println(Thread.currentThread().getName()
					+" is sleeping.");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName()
				+" has released LockCustom.");

		lockCustom.unlock();

	}

}
