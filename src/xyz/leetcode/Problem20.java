package xyz.leetcode;

import java.util.Stack;

// TOOL�� ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч
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

    // �ж����������Ƿ�ƥ��,����ǿ����ţ��ұ��Ǳ�����
    public boolean match(char a, char b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}
