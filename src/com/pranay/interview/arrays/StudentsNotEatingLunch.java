package com.pranay.interview.arrays;

/**
 * 1700. Number of Students Unable to Eat Lunch
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class StudentsNotEatingLunch {
    public static void main(String[] args) {
        int[] students = {1,1,0,0}, sandwiches = {0,1,0,1};
        int count = countStudents(students, sandwiches);
        System.out.println("Ans : " + count);
    }

    private static int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];

        for (int stud: students)
            count[stud]++;

        for (int s: sandwiches) {
            if (count[s] == 0)
                return count[1 - s];

            count[s]--;
        }

        return 0;
    }
}
