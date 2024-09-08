package com.pranay.flipkart;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * set of courses student has to take
 * {{1, 2}, {2, 3}, {1, 4}}
 * output: order in which student will take courses
 * 1 -> 2 -> 4 -> 3 indegree of courses
 * 1 -> 4 -> 2 -> 3
 * pick the course with 0 indegree, and remove from from other courses.
 */
public class Question2 {
    public static void main(String[] args) {
        int[][] courses = new int[][]{{1, 2}, {2, 3}, {1, 4}};
        int maxCourses = 4;
        Question2 q2 = new Question2();
        List<Integer> order = q2.giveOrderOfCourses(courses, maxCourses);
        System.out.println(order);
    }

    private List<Integer> giveOrderOfCourses(int[][] courses, int maxCourses) {
        int[] indegree = new int[maxCourses + 1];
        for (int[] course: courses) {
            indegree[course[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int currCourse = q.poll();
            ans.add(currCourse);

            for (int[] course : courses) {
                if (course[0] == currCourse) {
                    indegree[course[1]]--;

                    if (indegree[course[1]] == 0) {
                        q.offer(course[1]);
                    }
                }
            }
        }

        return ans;
    }
}
