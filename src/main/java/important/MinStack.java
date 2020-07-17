package important;

import java.util.Stack;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.size() <= 0) {
            minStack.push(x);
        } else {
            if (x > minStack.peek()) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
