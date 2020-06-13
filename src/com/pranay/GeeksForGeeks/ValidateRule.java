package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.List;

class Rule {
    String expression;
    List<Rule> rules;

    public Rule(String expression, List<Rule> rules) {
        this.expression = expression;
        this.rules = rules;
    }
}

public class ValidateRule {
    public static void main(String[] args) {
        Rule rule = new Rule(null, Arrays.asList(
                new Rule("STRING1", null),
                new Rule(null, Arrays.asList(
                        new Rule("STRING5", null)
                )),
                new Rule("STRING3", null),
                new Rule("DATE", null)
        ));
//        Rule rule = new Rule("STRING", null);

        int count = validCount(rule);
        System.out.println("Count : " + count);
    }

    private static int validCount(Rule rule) {
        int count = 0;

        if (rule == null) {
            return 0;
        }

        if (rule.expression != null && rule.expression.contains("STRING")) {
            return 1;
        }

        if (rule.expression != null) {
            return 0;
        }

        if (rule.rules == null) {
            return 0;
        }

        for (int i = 0; i<rule.rules.size(); i++) {
            count += validCount(rule.rules.get(i));
        }

        return count;
    }
}
