package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link FactoryMachines}.
 * Run main: each case feeds input to FactoryMachines.main and compares stdout.
 * Each case gets 3 seconds; a slower run is reported as TIMEOUT.
 */
public class FactoryMachinesTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "3 7\n3 2 5\n", "8"},
            {"one machine, one product", "1 1\n5\n", "5"},
            {"one machine, many products", "1 4\n3\n", "12"},
            {"identical machines", "3 6\n2 2 2\n", "4"},
            {"fast machine does everything", "2 5\n1 100\n", "5"},
            {"fewer products than machines", "5 2\n4 1 3 2 5\n", "2"},
            {"slow machines still help", "2 5\n2 3\n", "6"},
            {"large machine times", "2 3\n1000000000 999999999\n", "1999999998"},
            {"answer overflows int", "1 1000000000\n1000000000\n", "1000000000000000000"},
            {"large t, fast machines", "3 1000000000\n1 1 1\n", "333333334"},
    };

    private static final long TIME_LIMIT_MS = 3000;

    public static void main(String[] args) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        int passed = 0;

        for (int i = 0; i < CASES.length; i++) {
            String name = CASES[i][0], input = CASES[i][1], expected = CASES[i][2];

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            System.setOut(new PrintStream(out));
            Thread worker = new Thread(() -> {
                try {
                    FactoryMachines.main(new String[0]);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            worker.setDaemon(true);
            worker.start();
            worker.join(TIME_LIMIT_MS);
            boolean timedOut = worker.isAlive();
            System.setIn(originalIn);
            System.setOut(originalOut);
            if (timedOut) {
                System.out.printf("#%d %-38s TIMEOUT (> %d ms)%n", i + 1, name, TIME_LIMIT_MS);
                continue;
            }

            String actual = out.toString().replace("\r\n", "\n").trim();
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-38s %s%n", i + 1, name, ok ? "PASS" : "FAIL");
            if (!ok) {
                System.out.println("   expected: " + expected.replace("\n", " "));
                System.out.println("   got:      " + actual.replace("\n", " "));
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
        System.exit(0);   // stop any timed-out case still running
    }
}
