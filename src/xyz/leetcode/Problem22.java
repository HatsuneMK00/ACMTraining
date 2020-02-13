package xyz.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem22 {
    public static void main(String[] args) {
        Problem22 problem22 = new Problem22();
        System.out.println(problem22.generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> answer = new ArrayList<>();
        generateParenthesisRecursive(n, answer, 0, stringBuilder, 0);
        return answer;
    }

    public void generateParenthesisRecursive(int n, List<String> answer, int index, StringBuilder stringBuilder, int balance) {
        if (index == 2 * n) {
            if (balance == 0) {
                answer.add(stringBuilder.toString());
                return;
            } else {
                return;
            }
        }
        if (balance < 0 || balance > n) {
            return;
        }

        stringBuilder.append('(');
        generateParenthesisRecursive(n, answer, index + 1, stringBuilder, balance + 1);
        stringBuilder.deleteCharAt(index);
        stringBuilder.append(')');
        generateParenthesisRecursive(n, answer, index + 1, stringBuilder, balance - 1);
        stringBuilder.deleteCharAt(index);
    }
}
