package com.pranay.interview.graph;

// solution : https://leetcode.com/articles/course-schedule/
// https://www.youtube.com/watch?v=0LjVxtLnNOk - very good (implementation explanation)

import java.util.Arrays;
import java.util.Stack;

public class CourseScheduleTopologicalSort {
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{0, 1}};

		boolean canFinish = canFinish(numCourses, prerequisites);
		System.out.println("can finish : " +canFinish);
	}

	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] inDegree = new int[numCourses];
		int count = 0;

		for (int i = 0; i<prerequisites.length; i++) {
			inDegree[prerequisites[i][0]]++;
		}

		System.out.println(Arrays.toString(inDegree));
		Stack<Integer> stk = new Stack<>();

		for (int i=0; i< inDegree.length; i++) {
			if (inDegree[i] == 0) {
				stk.push(i);
			}
		}

		while (!stk.isEmpty()) {
			int curr = stk.pop();
			count++;
            System.out.println(curr);
			for (int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == curr) {
					inDegree[prerequisites[i][0]]--;
                    System.out.println(Arrays.toString(inDegree));
					if (inDegree[prerequisites[i][0]] == 0) {
						stk.push(prerequisites[i][0]);
					}
				}
			}
		}
		return count == numCourses;
	}
}
