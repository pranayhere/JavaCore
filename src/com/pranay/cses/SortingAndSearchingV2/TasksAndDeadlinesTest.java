package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link TasksAndDeadlines}.
 * Run main: each case feeds input to TasksAndDeadlines.main and compares stdout.
 */
public class TasksAndDeadlinesTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "3\n6 10\n8 15\n5 12\n", "2"},
            {"single task", "1\n3 10\n", "7"},
            {"single task, negative reward", "1\n10 3\n", "-7"},
            {"all rewards negative", "3\n5 1\n4 1\n3 1\n", "-19"},
            {"same duration, different deadlines", "3\n2 5\n2 9\n2 1\n", "3"},
            {"same deadline, different durations", "3\n3 10\n1 10\n2 10\n", "20"},
            {"deadline doesn't change the order", "2\n1 1\n5 100\n", "94"},
            {"ties in duration", "3\n4 7\n4 7\n1 2\n", "1"},
            {"unsorted input", "4\n7 20\n1 3\n4 9\n2 8\n", "15"},
            {"answer overflows int (n = 200000, a = d = 10^6)", maxInput(200000), "-19999900000000000"},
    };

    // n tasks, each with duration 10^6 and deadline 10^6
    private static String maxInput(int n) {
        StringBuilder sb = new StringBuilder().append(n).append('\n');
        for (int i = 0; i < n; i++) {
            sb.append("1000000 1000000\n");
        }
        return sb.toString();
    }

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
                TasksAndDeadlines.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            String actual = out.toString().replace("\r\n", "\n").trim();
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-50s %s%n", i + 1, name, ok ? "PASS" : "FAIL");
            if (!ok) {
                System.out.println("   expected: " + expected.replace("\n", " "));
                System.out.println("   got:      " + actual.replace("\n", " "));
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }
}
