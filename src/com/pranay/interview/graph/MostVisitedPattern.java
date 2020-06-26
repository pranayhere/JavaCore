package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Event {
    public String user;
    public int timestamp;
    public String web;

    Event(String user, int timestamp, String web) {
        this.user = user;
        this.timestamp = timestamp;
        this.web = web;
    }

    @Override
    public String toString() {
        return "Event{" +
                "user='" + user + '\'' +
                ", timestamp=" + timestamp +
                ", web='" + web + '\'' +
                '}' + '\n';
    }
}
public class MostVisitedPattern {
    public static void main(String[] args) {
        String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};

        List<String> ans = mostVisitedPattern(username, timestamp, website);
        System.out.println(ans);
    }

    private static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i<username.length; i++) {
            events.add(new Event(username[i], timestamp[i], website[i]));
        }

        Collections.sort(events, (a, b) -> a.timestamp - b.timestamp);
        System.out.println(events);

        Map<String, List<String>> userToWeb = new HashMap<>();
        for (Event e : events) {
            userToWeb.computeIfAbsent(e.user, k -> new ArrayList<>()).add(e.web);
        }

        System.out.println(userToWeb);

        Map<String, Integer> webTofreq = new HashMap<>();
        for (String user: userToWeb.keySet()) {
            Set<String> seqs = get3Seq(userToWeb.get(user));
            for (String seq : seqs)
                webTofreq.put(seq, webTofreq.getOrDefault(seq, 0) + 1);
        }

        System.out.println(webTofreq);

        int max = 0;
        String ans = "";
        for (String seq : webTofreq.keySet()) {
            int freq = webTofreq.get(seq);
            if (freq < max) {
            } else if (freq == max) {
                ans = seq.compareTo(ans) < 0 ? seq : ans;
            } else { // freq > max
                ans = seq;
                max = freq;
            }

        }
        return Arrays.asList(ans.split("#"));
    }

    private static Set<String> get3Seq(List<String> webs) {
        Set<String> res = new HashSet<>();
        if (webs.size() < 3)
            return res;
        dfs(webs, 0, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(List<String> webs, int idx, ArrayList<String> tmp, Set<String> res) {
        if (tmp.size() == 3) {
            String seq = tmp.get(0) + "#" + tmp.get(1) + "#" + tmp.get(2);
            res.add(seq);
            return;
        }

        for (int i = idx; i < webs.size(); i++) {
            tmp.add(webs.get(i));
            dfs(webs, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
