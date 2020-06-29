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
        String[] username = {"hyu","hyu","hyu","dr","dr","hyu","hyu","dr","hyu","rbqzyvz","hyu","hyu"};
        int[] timestamp = {843689154,476079714,961070284,625578364,920926840,340946294,447539515,227388644,376948108,641949100,767785236,877838661};
        String[] website = {"ckjgtzag","kvnkuovetb","whl","whl","gcunk","kv","gcunk","jytdzirgip","tjloxlamjn","cixdil","riqwxelwpi","jepphzino"};

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


/*
["hyu","hyu","hyu","dr","dr","hyu","hyu","dr","hyu","rbqzyvz","hyu","hyu"]
[843689154,476079714,961070284,625578364,920926840,340946294,447539515,227388644,376948108,641949100,767785236,877838661]
["ckjgtzag","kvnkuovetb","whl","whl","gcunk","kv","gcunk","jytdzirgip","tjloxlamjn","cixdil","riqwxelwpi","jepphzino"]


{hyu=[kv, tjloxlamjn, gcunk, kvnkuovetb, riqwxelwpi, ckjgtzag, jepphzino, whl], rbqzyvz=[cixdil], dr=[jytdzirgip, whl, gcunk]}
{kv#riqwxelwpi#whl=1, kv#gcunk#whl=1, kv#tjloxlamjn#kvnkuovetb=1, jytdzirgip#whl#gcunk=1, kv#riqwxelwpi#jepphzino=1, kv#kvnkuovetb#whl=1, kv#gcunk#riqwxelwpi=1, kv#gcunk#jepphzino=1, kv#gcunk#ckjgtzag=1, kv#tjloxlamjn#whl=1, kv#tjloxlamjn#riqwxelwpi=1, kv#tjloxlamjn#ckjgtzag=1, kv#ckjgtzag#jepphzino=1, kv#kvnkuovetb#ckjgtzag=1, kv#ckjgtzag#whl=1, kv#tjloxlamjn#jepphzino=1, kv#riqwxelwpi#ckjgtzag=1, kv#kvnkuovetb#jepphzino=1, kv#jepphzino#whl=1, kv#kvnkuovetb#riqwxelwpi=1, kv#tjloxlamjn#gcunk=1, kv#gcunk#kvnkuovetb=1}


["jytdzirgip","whl","gcunk"]

["ckjgtzag","jepphzino","whl"]
 */