package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess {
    public static void main(String[] args) {
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        int kill = 5;

        List<Integer> ans = killProcess(pid, ppid, kill);
        System.out.println("Ans : " + ans);
    }

    private static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> g = new HashMap<>();

        for (int i = 0; i < pid.size(); i++) {
            g.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(kill);


        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);

            for (int child: g.getOrDefault(curr, new ArrayList<>())) {
                q.offer(child);
            }
        }
        return ans;
    }
}
