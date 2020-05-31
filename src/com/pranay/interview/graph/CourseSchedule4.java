package com.pranay.interview.graph;

//https://leetcode.com/problems/course-schedule-iv/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule4 {
    public static void main(String[] args) {
        int n = 4;
        int[][] prerequisites = {{2,3},{2,1},{0,3},{0,1}};
        int[][] queries = {{0,1},{0,3},{2,3},{3,0},{2,0},{0,2}};
        List<Boolean> ans = checkIfPrerequisite(n, prerequisites, queries);
        System.out.println(ans);
    }

    private static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Set<Integer>> prerequisitesMap = new HashMap<>();

        for (int i = 0; i<n; i++) {
            prerequisitesMap.put(i, new HashSet<>());
            adj.put(i, new HashSet<>());
        }

        for (int[] pre: prerequisites) {
            indegree[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        System.out.println("Indegree : " + Arrays.toString(indegree));
        System.out.println("Adjacent : "  + adj);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            Set<Integer> set = adj.get(node);
            for (int next : set) {
                prerequisitesMap.get(next).add(node);
                prerequisitesMap.get(next).addAll(prerequisitesMap.get(node));
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println("prerequisite : " + prerequisitesMap);
        List<Boolean> res = new ArrayList<>();
        for (int[] pair : queries) {
            Set<Integer> set = prerequisitesMap.get(pair[1]);
            if (set.contains(pair[0])) {
                res.add(true);
            }
            else {
                res.add(false);
            }
        }
        return res;
    }
}
