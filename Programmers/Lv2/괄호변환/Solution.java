package Lv2.괄호변환;

import java.util.Stack;

public class Solution {
    static public String solution(String p) {
        String answer = "";

        answer = division(p);

        return answer;
    }

    static public String division(String p) {
        if (p.isEmpty())
            return p;

        int leftPar = 0;
        int rightPar = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < p.length(); ++i) {
            if (leftPar == rightPar && leftPar != 0) {
                v.append(p.substring(i));
                break;
            }

            u.append(p.charAt(i));

            if (p.charAt(i) == '(') {
                ++leftPar;
                st.push(p.charAt(i));
            }
            else {
                ++rightPar;
                if (!st.isEmpty())
                    st.pop();
            }
        }

        if (st.isEmpty())
            result.append(u.append(division(v.toString())));
        else {
            result.append('(');
            result.append(division(v.toString()));
            result.append(')');
            result.append(uIsNotAlright(u.toString()));
        }

        return result.toString();
    }

    static public String uIsNotAlright(String u) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < u.length() - 1; ++i) {
            if (u.charAt(i) == '(')
                result.append(')');
            else
                result.append('(');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }
}
