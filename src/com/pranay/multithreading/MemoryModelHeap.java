package com.pranay.multithreading;

class MyObject {
    public MyObject() {}
}

class MyRunnable implements Runnable {
    int count = 0;
    MyObject myObject;

    public MyRunnable(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            count++;

            System.out.println(Thread.currentThread().getName() + " Count : " + count + " myObject " + myObject);
        }
    }
}

public class MemoryModelHeap {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();

        Runnable runnable = new MyRunnable(myObject);

        Thread t1 = new Thread(runnable, "Th1");
        Thread t2 = new Thread(runnable, "Th2");
        t1.start();
        t2.start();
    }
}
