package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class DesignBrowserHistory {
    int currentIndex = 0;
    List<String> history = new ArrayList<>();
    public DesignBrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        while (currentIndex != history.size() - 1)
            history.remove(history.size() - 1);
        history.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        currentIndex=Math.max(currentIndex - steps, 0);
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex=Math.min(currentIndex + steps, history.size() - 1);
        return history.get(currentIndex);
    }

    public static void main(String[] args) {
        DesignBrowserHistory browserHistory = new DesignBrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}
