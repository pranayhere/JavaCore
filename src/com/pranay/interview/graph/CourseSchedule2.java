package com.pranay.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;

        int[] topologicalOrder = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(topologicalOrder));
    }

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer> topologicalOrder = new ArrayList<>();
        for (int i = 0; i<prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        System.out.println(Arrays.toString(indegree));

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                stk.push(i);
            }
        }

        while (!stk.isEmpty()) {
            int curr = stk.pop();
            topologicalOrder.add(curr);
//            System.out.println("Current : " + curr);
            for (int i = 0; i<prerequisites.length; i++) {
                if (prerequisites[i][1] == curr) {
                    indegree[prerequisites[i][0]]--;
//                    System.out.println(Arrays.toString(indegree));
                    if (indegree[prerequisites[i][0]] == 0) {
                        stk.push(prerequisites[i][0]);
                    }
                }
            }
        }
//        System.out.println(topologicalOrder);
        if (topologicalOrder.size() == numCourses) {
            int[] ans = new int[topologicalOrder.size()];
            for (int i = 0; i<ans.length; i++) {
                ans[i] = topologicalOrder.get(i);
            }
            return ans;
        }

        return new int[0];
    }

}
