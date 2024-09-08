package com.pranay.synchronization;

public class Counter {

    public int count = 0;
    Object obj = new Object();

    public synchronized void getCounter() {
        System.out.println(count);
    }

    public synchronized void setCounter() {
        this.count++;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        byte a = 127;
        byte b = 127;
//        b = a + b; // error : cannot convert from int to byte
//        b += a;

        char[] arr = {'a', 'b', 'c'};
        char[] rev = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rev[arr.length - 1 - i] = arr[i];
        }

        String ans = String.valueOf(rev);
        System.out.println(ans);

        Thread thread1 = new Thread(counter::setCounter);
        Thread thread2 = new Thread(counter::getCounter);

        thread1.start();
        thread2.start();
    }
}

