package com.pranay.interview.graph;

// solution : https://leetcode.com/articles/course-schedule/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CourseScheduleTopologicalSort {
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {{1,0}, {0,1}};

		boolean canFinish = canFinish(numCourses, prerequisites);
		System.out.println("can finish : " +canFinish);
	}

	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> courseDict = new HashMap<>();
		for (int[] relation: prerequisites) {
			if (courseDict.containsKey(relation[1])) {
				courseDict.get(relation[1]).add(relation[0]);
			} else {
				List<Integer> nextCourses = new LinkedList<>();
				nextCourses.add(relation[0]);
				courseDict.put(relation[1], nextCourses);
			}
		}

		courseDict.forEach((k, v) -> System.out.println(k + " - " + v));

		boolean[] path = new boolean[numCourses];

		for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
			if (isCyclic(currCourse, courseDict, path)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isCyclic(int currCourse, Map<Integer, List<Integer>> courseDict, boolean[] path) {
		if (path[currCourse]) {
			return true;
		}

		if (!courseDict.containsKey(currCourse)) {
			return false;
		}

		path[currCourse] = true;

		boolean ret = false;
		for (Integer nextCourse: courseDict.get(currCourse)) {
			ret = isCyclic(nextCourse, courseDict, path);
			if (ret) {
				break;
			}
		}

		path[currCourse] = false;
		return ret;
	}
}
