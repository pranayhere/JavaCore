package com.pranay.interview.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextEditor {
    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        String[][] queries = {
                {"APPEND", "Hey"},
                {"APPEND", "There"},
                {"MOVE", "3"},
                {"APPEND", ", "},
                {"COPY", ""}
        };

        String[] ans = te.solution(queries);
        System.out.println(Arrays.toString(ans));
    }

    int cursor = -1;
    int start = -1;
    int end = -1;
    String copy = "";

    String[] solution(String[][] queries) {
        List<String> doc = new ArrayList<>();

        for (String[] q : queries) {
            switch (q[0]) {
                case "APPEND":
                    append(doc, q);
                    break;
                case "MOVE":
                    move(doc, q);
                    break;
                case "BACKSPACE":
                    backspace(doc);
                    break;
                case "SELECT":
                    select(doc, q);
                    break;
                case "COPY":
                    copy(doc, q);
                    break;
                case "PASTE":
                    paste(doc);
                    break;
                default:
                    System.out.println("Unknown comand : " + Arrays.toString(q));
            }

            System.out.println(doc.get(doc.size() - 1));
        }

        String[] ans = new String[doc.size()];
        for (int i = 0; i < doc.size(); i++) {
            ans[i] = doc.get(i);
        }

        return ans;
    }

    public void append(List<String> doc, String[] q) {
        System.out.println(start + " --- " + end + " --- " + cursor);
        String prev = "";
        if (!doc.isEmpty())
            prev = doc.get(doc.size() - 1);

        String str = "";

        if (start >= 0 && end >= 0) {
            prev = prev.substring(0, start) + prev.substring(end);
            cursor = start;
            start = -1;
            end = -1;
        }

        if (cursor >= 0) {
            str = prev.substring(0, cursor) + q[1] + prev.substring(cursor);
        } else {
            str = prev + q[1];
        }

        doc.add(str);
        if (cursor >= 0)
            cursor += q[1].length();
    }

    public void move(List<String> doc, String[] q) {
        String prev = "";
        if (!doc.isEmpty())
            prev = doc.get(doc.size() - 1);

        doc.add(prev);

        cursor = Integer.parseInt(q[1]);

        if (cursor < 0)
            cursor = 0;
        else if (cursor > prev.length())
            cursor = prev.length() - 2;

        System.out.println("cursor :" + cursor);
    }

    public void backspace(List<String> doc) {
        String prev = "";
        if (!doc.isEmpty())
            prev = doc.get(doc.size() - 1);

        if (prev.length() != 0 && start >= 0 && end >= 0) {
            prev = prev.substring(0, start) + prev.substring(end);
            cursor = start;
            start = -1;
            end = -1;

            doc.add(prev);
            return;
        }
        if (prev.length() == 0)
            doc.add("");
        else {
            if (cursor >= 0) {
                prev = prev.substring(0, cursor - 1) + prev.substring(cursor);
            } else {
                prev = prev.substring(0, prev.length() - 1);
            }
            doc.add(prev);
        }

        cursor--;
    }

    public void select(List<String> doc, String[] q) {
        String prev = "";
        if (!doc.isEmpty())
            prev = doc.get(doc.size() - 1);

        doc.add(prev);

        start = Integer.parseInt(q[1]);
        end = Integer.parseInt(q[2]);

        if (start < 0)
            start = 0;
        if (start > prev.length())
            start = prev.length() - 1;

        if (end < 0)
            end = 0;
        if (end > prev.length())
            end = prev.length() - 1;
    }

    public void copy(List<String> doc, String[] q) {
        String prev = "";
        if (!doc.isEmpty())
            prev = doc.get(doc.size() - 1);

        doc.add(prev);

        copy = prev.substring(start, end);
    }

    public void paste(List<String> doc) {
        append(doc, new String[]{"APPEND", copy});
    }
}
