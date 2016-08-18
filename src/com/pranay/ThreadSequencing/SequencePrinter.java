package com.pranay.ThreadSequencing;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
 
 
public class SequencePrinter {
    
    public static void main(String[] args) {
        // Create the workers
        Worker w1 = new Worker();
        Worker w2 = new Worker();
        Worker w3 = new Worker();
        Worker w4 = new Worker();
        
        // chain them in a round robin fashion
        w1.setNext(w2);
        w2.setNext(w3);
        w3.setNext(w4);
        w4.setNext(w1);
        
        // Create named threads for the workers
        Thread t1 = new Thread(w1, "Thread-1 - ");
        Thread t2 = new Thread(w2, "Thread-2 - ");
        Thread t3 = new Thread(w3, "Thread-3 - ");
        Thread t4 = new Thread(w4, "Thread-4 - ");
        
        // start the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        
        // Seed the first worker
        w1.accept(1);
    }
}