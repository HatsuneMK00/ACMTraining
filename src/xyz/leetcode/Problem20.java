package xyz.leetcode;

import java.util.Stack;

// TOOL： 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
public class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentC = s.charAt(i);
            if (currentC == '(' || currentC == '[' || currentC == '{') {
                stack.push(currentC);
            } else if (currentC == ')' || currentC == ']' || currentC == '}') {
                if (!stack.empty() && match(stack.peek(), currentC)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    // 判断两个括号是否匹配,左边是开括号，右边是闭括号
    public boolean match(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}
