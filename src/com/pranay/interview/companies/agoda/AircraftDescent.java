package com.pranay.interview.companies.agoda;

import java.util.Arrays;

/*
Problem: Maximum Aircrafts Shot Down Before Crash

You are given n aircrafts in the sky.

Each aircraft i has:
    startHeight[i]  -> initial height above ground
    descentRate[i]  -> how much height it loses every second

At every second:
    - All aircraft simultaneously decrease their height by their descentRate
    - You are allowed to shoot down at most one aircraft per second
    - A shot aircraft is immediately removed from the sky

An aircraft crashes and can no longer be shot if its height becomes <= 0.

Your task is to determine the maximum number of aircraft you can shoot down before they crash.

------------------------------------------------------------

Important: How descent works (Illustration)

Let an aircraft have:
    startHeight = h
    descentRate = r

Then its height over time is:

Second 0: h
Second 1: h - r
Second 2: h - 2r
Second 3: h - 3r
...
It crashes when height <= 0.

------------------------------------------------------------

Example 1 (with full descent simulation):

startHeight = [1, 3, 4, 4, 5]
descentRate = [1, 2, 1, 1, 2]

Let’s track heights each second:

Second 0:
A1 = 1
A2 = 3
A3 = 4
A4 = 4
A5 = 5

Second 1:
A1 = 0   (crashes immediately after this second)
A2 = 1
A3 = 3
A4 = 3
A5 = 3

Second 2:
A2 = -1  (crashed)
A3 = 2
A4 = 2
A5 = 1

Second 3:
A3 = 1
A4 = 1
A5 = -1  (crashed)

Second 4:
A3 = 0   (crashed)
A4 = 0   (crashed)

------------------------------------------------------------

You can shoot at most 1 aircraft per second, before it crashes.

Goal:
Maximize number of aircraft shot down before they hit height <= 0.

------------------------------------------------------------

Example 2 (descent illustration):

startHeight = [2, 2, 2]
descentRate = [1, 2, 3]

Second 0:
2, 2, 2

Second 1:
1, 0, -1  -> A2 and A3 crash

Second 2:
0         -> A1 crashes

------------------------------------------------------------

Output:
Return the maximum number of aircraft that can be shot down before crashing.
*/
public class AircraftDescent {
    public static void main(String[] args) {
        int[] startHeight = {1, 3, 4, 4, 5};
        int[] descentRate = {1, 2, 1, 1, 2};

        int n = startHeight.length;

        int[] deadline = new int[n];

        // Step 1: compute deadlines
        for (int i = 0; i < n; i++) {
            int h = startHeight[i];
            int r = descentRate[i];

            // ceil(h / r)
            int d = (h + r - 1) / r;
            deadline[i] = d;
        }

        // Step 2: sort deadlines
        Arrays.sort(deadline);

        // Step 3: greedy scheduling
        int time = 0;
        int count = 0;

        for (int d : deadline) {
            if (time + 1 <= d) {
                count++;
                time++;
            }
        }

        System.out.println(count);
    }
}
