package com.pranay.interview.graph;

public class StudentAttendanceRecord2 {
    public static void main(String[] args) {
        int n = 2;
        StudentAttendanceRecord2 sar = new StudentAttendanceRecord2();
        int record = sar.checkRecord(n);
        System.out.println("Record : " + record);
    }

    int N;
    int count = 0;
    int M = 1000000007;

    private int checkRecord(int n) {
        N = n;
        dfs("", 0);
        return count;
    }

    public void dfs(String att, int start) { // att = attendance pattern
        if (start > N)
            return;

        if (isValid(att)) {
            count = (count + 1) % M;
        }

        dfs(att + "A", start + 1);
        dfs(att + "L", start + 1);
        dfs(att + "P", start + 1);
    }

    public boolean isValid(String str) {
        if (str.length() < N || str.contains("LLL"))
            return false;

        int aCnt = 0;
        for (char c: str.toCharArray()) {
            if (c == 'A')
                aCnt++;
        }
        return aCnt < 2;
    }

    private int checkRecordDP(int n) {
        long a = 1; // the number of answer which don't include 'A' , not ending with 'L' -> N        -> P
        long b = 1; // the number of answer which don't include 'A' , ending with one 'L' -> NL       -> L
        long c = 0; // the number of answer which don't include 'A' , ending with two 'L' -> NLL      -> ''
        long d = 1; // the number of answer which includes 'A' , not ending with 'L'      -> A_N      -> A
        long e = 0; // the number of answer which includes 'A', ending with one 'L'       -> A_NL     -> ''
        long f = 0; // the number of answer which includes 'A', ending with two 'L'       -> A_NLL    -> ''

        for (int i = 1; i < n; i++) {
            long temp1 = (a + b + c) % M;
            long temp2 = (temp1 + d + e + f) % M;
            c = b;
            b = a;
            f = e;
            e = d;
            a = temp1;
            d = temp2;
        }

        return (int) ((a + b + c + d + e + f) % M);
    }
}
