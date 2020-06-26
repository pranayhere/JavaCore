package com.pranay.interview.graph;

// solution : https://leetcode.com/articles/course-schedule/
// https://www.youtube.com/watch?v=0LjVxtLnNOk - very good (implementation explanation)

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class CourseScheduleTopologicalSort {
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{0, 1}, {1, 0}};

		boolean canFinish = canFinish(numCourses, prerequisites);
		System.out.println("can finish : " +canFinish);
	}

	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		for (int[] prerequisite: prerequisites) {
		    indegree[prerequisite[0]]++;
        }

        System.out.println(Arrays.toString(indegree));

        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int i = 0; i<prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        q.offer(prerequisites[i][0]);
                    }
                }
            }
        }
		return count == numCourses;
	}
}
