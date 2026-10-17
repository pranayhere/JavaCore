package com.pranay.cses.SortingAndSearchingV2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Local test cases for {@link Playlist}.
 * Run main: each case feeds input to Playlist.main and compares stdout.
 */
public class PlaylistTest {

    // { name, input, expected output }
    private static final String[][] CASES = {
            {"sample", "8\n1 2 1 3 2 7 4 2\n", "5"},
            {"single song", "1\n5\n", "1"},
            {"all unique", "5\n1 2 3 4 5\n", "5"},
            {"all the same", "4\n7 7 7 7\n", "1"},
            {"repeat right next to each other", "5\n1 2 2 3 4\n", "3"},
            {"best window at the end", "6\n1 1 2 3 4 5\n", "5"},
            {"window slides past two repeats", "7\n1 2 3 1 4 5 2\n", "5"},
            {"repeat of an old song far back", "6\n1 2 3 4 5 1\n", "5"},
            {"alternating two songs", "6\n1 2 1 2 1 2\n", "2"},
            {"large ids", "5\n1000000000 1 1000000000 999999999 2\n", "4"},
            {"old repeat before window start (abba)", "4\n1 2 2 1\n", "2"},
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
                Playlist.main(new String[0]);
            } finally {
                System.setIn(originalIn);
                System.setOut(originalOut);
            }

            String actual = out.toString().replace("\r\n", "\n").trim();
            boolean ok = actual.equals(expected);
            if (ok) passed++;

            System.out.printf("#%d %-52s %s%n", i + 1, name, ok ? "PASS" : "FAIL");
            if (!ok) {
                System.out.println("   expected: " + expected.replace("\n", " "));
                System.out.println("   got:      " + actual.replace("\n", " "));
            }
        }

        System.out.printf("%n%d/%d passed%n", passed, CASES.length);
    }
}
