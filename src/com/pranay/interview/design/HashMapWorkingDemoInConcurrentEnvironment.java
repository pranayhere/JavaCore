package com.pranay.interview.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HashMapWorkingDemoInConcurrentEnvironment {
    private Map<Long, String> cache = new HashMap<>();
    public synchronized String put(Long key, String value) {
        return cache.put(key, value);
    }

    public String get(Long key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        HashMapWorkingDemoInConcurrentEnvironment cache = new HashMapWorkingDemoInConcurrentEnvironment();
        class Producer implements Callable<String> {
            private Random rand = new Random();
            public String call() throws Exception {
                while (true) {
                    long key = rand.nextInt(1000);
                    cache.put(key, Long.toString(key));
                    if (cache.get(key) == null) {
                        System.out.println("Key " + key + " has not been put in the map");
                    }
//                    else {
//                        System.out.println("Key " + key + " successfully put in the map");
//                    }
                }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        System.out.println("Adding value...");
        try {
            for (int i = 0; i < 4; i++) {
                executorService.submit(new Producer());
            }
        } finally {
            executorService.shutdown();
        }
    }
}
