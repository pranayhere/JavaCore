package com.pranay.interview.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 *
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */

public class ReorderLogFile {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] orderedLog = reorderLogFiles(logs);
        System.out.println(Arrays.toString(orderedLog));
    }

    private static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            System.out.println("split1 : " + Arrays.toString(split1) + " - " +split1[1].charAt(0));
            System.out.println("split2 : " + Arrays.toString(split2) + " - " + split2[1].charAt(0));
            System.out.println("cmp : " + split1[1].compareTo(split2[1]));
//            System.out.println("Digit : " + isDigit1 ? (isDigit2 ? 0 : 1) : -1);
            System.out.println("====================");

            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}
