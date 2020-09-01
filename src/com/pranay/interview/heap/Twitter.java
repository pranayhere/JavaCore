package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Twitter {
    public class Tweet {
        int timestamp;
        int tweetId;

        public Tweet(int timestamp, int tweetId) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
    }

    Map<Integer, Set<Integer>> followMap = new HashMap<Integer, Set<Integer>>();
    Map<Integer, List<Tweet>> tweetMap = new HashMap<Integer, List<Tweet>>();

    AtomicInteger ts;

    public Twitter() {
        ts = new AtomicInteger(0);
    }

    private void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(ts.getAndIncrement(), tweetId);
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweet);
    }

    private void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    private void unfollow(int followerId, int followeeId) {
        Set<Integer> followSet = followMap.get(followerId);
        if (followSet == null) {
            followSet = new HashSet<Integer>();
            followMap.put(followerId, followSet);
        }

        followSet.remove(followeeId);
    }

    private List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] it1, int[] it2) {
                return tweetMap.get(it2[0]).get(it2[1]).timestamp - tweetMap.get(it1[0]).get(it1[1]).timestamp;
            }
        });

        Set<Integer> followeeSet = new HashSet<>();
        followeeSet.add(userId);
        if (followMap.containsKey(userId))
            followeeSet.addAll(followMap.get(userId));

        for (Integer followee: followeeSet) {
            if (tweetMap.containsKey(followee)) {
                List<Tweet> tweetList = tweetMap.get(followee);

                if (tweetList.size() > 0)
                    pq.add(new int[] {followee, tweetList.size() - 1});
            }
        }

        while (feed.size() < 10 && pq.size() > 0) {
            int[] it = pq.poll();

            feed.add(tweetMap.get(it[0]).get(it[1]).tweetId);
            it[1]--;

            if (it[1] >= 0)
                pq.add(it);
        }

        return feed;
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.follow(1, 2); // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2); // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1)); // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}
