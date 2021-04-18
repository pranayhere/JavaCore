package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1834. Single-Threaded CPU
 * https://leetcode.com/problems/single-threaded-cpu/
 */
class Task {
    int id;
    int start;
    int time;

    public Task(int i, int s, int t) {
        id = i;
        start = s;
        time = t;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", start=" + start +
                ", time=" + time +
                '}';
    }
}

public class SingleThreadedCpu {
    public static void main(String[] args) {
//        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
//        int[][] tasks = {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        int[][] tasks = {{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};
        // [6,1,2,9,4,10,0,11,5,13,3,8,12,7]
        SingleThreadedCpu stu = new SingleThreadedCpu();
        int[] ans = stu.getOrder(tasks);
        System.out.println(Arrays.toString(ans));
    }

    public int[] getOrder(int[][] taskArr) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < taskArr.length; i++) {
            int[] t = taskArr[i];
            tasks.add(new Task(i, t[0], t[1]));
        }

        Collections.sort(tasks, (a, b) -> a.start - b.start);

        System.out.println(tasks);

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> a.time == b.time ? a.id - b.id : a.time - b.time);
        Task first = tasks.get(0);
        List<Integer> seen = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.start > first.start)
                break;
            pq.offer(t);
            seen.add(i);
        }

        List<Task> execs = new ArrayList<>();

        int completionTime = 0;

        while (!pq.isEmpty()) {
            Task curr = pq.poll();
            execs.add(curr);

            if (completionTime == 0)
                completionTime = curr.start + curr.time;
            else
                completionTime = completionTime + curr.time;

            for (int i = seen.get(seen.size() - 1) + 1; i < tasks.size(); i++) {
                if (seen.contains(i))
                    continue;

                Task t = tasks.get(i);
                if (t.start > completionTime)
                    break;
                pq.offer(t);
                seen.add(i);
            }

            System.out.println(pq);
        }

        int[] ans = new int[execs.size()];
        for (int i = 0; i < execs.size(); i++) {
            ans[i] = execs.get(i).id;
        }
        return ans;
    }
}
