package com.pranay.interview.greedy;

public class BrokenCalculator {
    public static void main(String[] args) {
        int X = 3, Y = 10;
        int steps = brokenCalc(X, Y);
        System.out.println("Min Steps : " + steps);
    }

    private static int brokenCalc(int X, int Y) {
        int steps = 0;
        while (Y > X) {
            steps++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }

        return steps + X - Y;
    }
}
