package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.Stack;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        boolean canFinish = canFinish(numCourses, prerequisites);
        System.out.println("can finish : " +canFinish);
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int i = 0; i<prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        System.out.println(Arrays.toString(indegree));
        Stack<Integer> stk = new Stack<>();
        for (int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                stk.push(i);
            }
        }

        int count = 0;
        while (!stk.isEmpty()) {
            int curr = stk.pop();
            count++;

            for (int i = 0; i<prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        stk.push(indegree[prerequisites[i][0]]);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
