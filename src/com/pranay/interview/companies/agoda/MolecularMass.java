package com.pranay.interview.companies.agoda;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Molecular Mass Calculator
 *
 * Atomic masses:
 * C = 12
 * H = 1
 * O = 16
 *
 * The input is a valid chemical formula consisting of:
 * - Atoms: C, H, O
 * - Parentheses: (, )
 * - Positive integer multipliers
 *
 * Rules:
 *
 * 1. The mass of an atom is its atomic mass.
 *
 * 2. If a number follows an atom, multiply the atom's mass
 *    by that number.
 *
 *    Example:
 *    H2 = 1 * 2 = 2
 *    O3 = 16 * 3 = 48
 *
 * 3. If a number follows a parenthesized group, multiply
 *    the entire group's mass by that number.
 *
 *    Example:
 *    (CH4)2
 *    = (12 + 1 * 4) * 2
 *    = 32
 *
 * 4. Adjacent atoms or groups are added together.
 *
 *    Example:
 *    CH
 *    = 12 + 1
 *    = 13
 *
 * Example 1:
 *
 * Input:
 * H(CH4)2
 *
 * Evaluation:
 * H(CH4)2
 * = 1 + (12 + 1 * 4) * 2
 * = 1 + 16 * 2
 * = 33
 *
 * Output:
 * 33
 *
 * Example 2:
 *
 * Input:
 * CH(CO2H)3
 *
 * Evaluation:
 * CO2H
 * = 12 + 16 * 2 + 1
 * = 45
 *
 * CH(CO2H)3
 * = 12 + 1 + 45 * 3
 * = 148
 *
 * Output:
 * 148
 *
 * Constraints:
 * - Formula is valid.
 * - Parentheses are balanced.
 * - Multipliers are positive integers.
 * - Answer fits in a 64-bit signed integer.
 */
class MolecularMass2 {
    static Map<Character, Integer> mass = new HashMap<>();

    static {
        mass.put('H', 1);
        mass.put('C', 12);
        mass.put('O', 8);
    }

    public static int evaluate(String formula) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);

            if (mass.containsKey(ch)) {
                st.push(mass.get(ch));
            }
            else if (ch == '(') {
                st.push(-1); // marker
            }
            else if (ch == ')') {
                int sum = 0;

                while (st.peek() != -1) {
                    sum += st.pop();
                }

                st.pop(); // remove '(' marker
                st.push(sum);
            }
            else if (Character.isDigit(ch)) {
                int num = ch - '0';
                st.push(st.pop() * num);
            }
        }

        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "CH(CO2H)3";
        System.out.println(evaluate(s)); // 33
    }
}

public class MolecularMass {
    public static void main(String[] args) {
        String formula = "CH(CO2H)3";
        int ans = findMass(formula);
        System.out.println(ans);
    }

    static Map<Integer, Integer> hm = new HashMap<>();
    private static int findMass(String formula) {
        Stack<Integer> stk = new Stack<>();
        int n = formula.length();

        for (int i = 0; i < n; i++) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                stk.push(i);
            } else if (ch == ')') {
                hm.put(stk.pop(), i);
            }
        }

        return dfs(formula, 0, n);
    }

    public static int dfs(String s, int startIdx, int endIdx) {
        Stack<Integer> stk = new Stack<>();

        for (int i = startIdx; i < endIdx; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < endIdx && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                stk.push(stk.pop() * num);
            } else if (ch == '(') {
                int num = dfs(s, i + 1, hm.get(i));
                i = hm.get(i);
                stk.push(num);
            } else {
                int num = 0;
                if (ch == 'C')
                    num = 12;
                else if (ch == 'H')
                    num = 1;
                else if (ch == 'I')
                    num = 8;

                stk.push(num);
            }
        }

        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.pop();
        }

        return res;
    }
}
