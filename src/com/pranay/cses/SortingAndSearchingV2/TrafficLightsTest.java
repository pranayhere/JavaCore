package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link TrafficLights}.
 * Run main: each case feeds input to TrafficLights.main and compares stdout,
 * ignoring whether answers are separated by spaces or newlines.
 */
public class TrafficLightsTest {

    // { name, input, expected output (answers separated by spaces) }
    private static final String[][] CASES = {
            {"sample", "8 3\n3 6 2\n", "5 3 3"},
            {"one light", "2 1\n1\n", "1"},
            {"lights from the left", "10 5\n1 2 3 4 5\n", "9 8 7 6 5"},
            {"lights from the middle down", "10 5\n5 4 3 2 1\n", "5 5 5 5 5"},
            {"max gap unchanged by a small split", "10 3\n2 1 6\n", "8 8 4"},
            {"two equal largest gaps", "10 2\n5 7\n", "5 5"},
            {"every position filled", "5 4\n2 4 1 3\n", "3 2 2 1"},
            {"largest street, lights at both ends", "1000000000 2\n1 999999999\n", "999999999 999999998"},
            {"random small", "20 8\n11 5 13 2 16 14 9 15\n", "11 9 7 7 6 6 4 4"},
    };

    public static void main(String[] args) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        int passed = 0;

        for (int i = 0; i < CASES.length; i++) {
            String name = CASES[i][0], input = CASES[i][1], expected = CASES[i][2];

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(out));
            try {
                TrafficLights.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            // answers may be separated by spaces or newlines, so compare them as tokens
            String actual = out.toString().trim().replaceAll("\\s+", " ");
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-38s %s%n", i + 1, name, ok ? "PASS" : "FAIL");
            if (!ok) {
                System.out.println("   expected: " + expected);
                System.out.println("   got:      " + actual);
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }
}
