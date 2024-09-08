package com.pranay.synchronization;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private Map<String, Integer> map = new HashMap<>();

    String text = "As a quick refresher: Partier, Candier, and Stringer";

    public void increment(String word) {
        System.out.println("incrementing " + word);
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    public int get(String word) {
        synchronized (Map.class) {
            return map.getOrDefault(word, 0);
        }
    }

    public void count() {
        synchronized (Map.class) {
            for (String word : text.split(" ")) {
                this.increment(word);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) {
        WordCount wordCount = new WordCount();
        WordCount wordCount2 = new WordCount();

        Thread th1 = new Thread(() -> {
            wordCount.count();
        });

        Thread th2 = new Thread(() -> {
            for (String word: wordCount.text.split(" ")) {
                System.out.println(word + " " + wordCount2.get(word));
            }
        });

        th1.start();
        th2.start();
    }
}
