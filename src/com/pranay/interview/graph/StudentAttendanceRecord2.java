package com.pranay.interview.graph;

public class StudentAttendanceRecord2 {
    public static void main(String[] args) {
        int n = 3;
        StudentAttendanceRecord2 sar = new StudentAttendanceRecord2();
        int record = sar.checkRecordDP(n);
        System.out.println("Record : " + record);
    }

    //Set<String> hs = new HashSet<>();
    int N;
    int count, M = 1000000007;

    private int checkRecord(int n) {
        N = n;
        dfs("", 0);
        //System.out.println(hs);
        return count;
    }

    public void dfs(String s, int start) {
        if (start > N)
            return;

        if (isValid(s))
            count = (count + 1) % M;

        dfs(s + "A", start + 1);
        dfs(s + "L", start + 1);
        dfs(s + "P", start + 1);
    }

    private boolean isValid(String s) {
        if (s.length() < N || s.contains("LLL"))
            return false;

        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A')
                count++;
        }

        if (count >= 2)
            return false;

        return true;
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
