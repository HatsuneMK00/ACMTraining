package xyz.nowcoder;

import java.util.Stack;

public class SimulateQueueWithStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (!stack1.isEmpty()) {
            stack2.push(node);
            copy(stack1, stack2);
        } else {
            stack1.push(node);
            copy(stack2, stack1);
        }
    }

    public int pop() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        } else {
            return stack2.pop();
        }
    }

    public void copy(Stack<Integer> from, Stack<Integer> to) {
        Stack<Integer> temp = new Stack<Integer>();
        Integer node;
        while (!from.isEmpty()) {
            node = from.pop();
            temp.push(node);
        }
        while (!temp.isEmpty()) {
            node = temp.pop();
            to.push(node);
        }
    }
}
