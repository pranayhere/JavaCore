package com.pranay.interview.stacks;

import java.util.Stack;

public class HtmlTags {
    public String findTag(String html) {
        Stack<String> stk = new Stack<>();
        StringBuilder tag = new StringBuilder();
        String tagStr = "";
        boolean newtag = false;
        for (char ch: html.toCharArray()) {
            if (ch == '<') {
                newtag = true;
            }

            if (!newtag)
                continue;

            tag.append(ch);

            if (ch != '<' && ch != '/' && ch != '>') {
                tagStr += ch;
            }

            if (ch == '>') {
                if (tag.toString().startsWith("</") && !stk.isEmpty() && tagStr.equals(stk.peek())) {
                    stk.pop();
                } else if (tag.toString().startsWith("</") && !stk.isEmpty() && !tagStr.equals(stk.peek())) {
                    return stk.peek();
                } else {
                    stk.push(tagStr);
                }

                tag = new StringBuilder();
                tagStr = "";
                newtag = false;
            }
        }

        if (!stk.isEmpty()) {
            return stk.pop();
        }

        return "true";
    }

    public static void main(String[] args) {
        HtmlTags ht = new HtmlTags();
        String str = "<div>";
//        String str = "<div>abc</div><p><em><i>test test test </b></em></p>";
//        String str = "<dvc>dasbdj asdjdjas avdhvasd</i>";

        System.out.println(ht.findTag(str));
    }
}
