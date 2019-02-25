package com.iwenchaos.mdualgor.stack;

import java.util.Stack;

/**
 * Created by chaos
 * on 2019/2/24. 16:24
 * 文件描述：
 */
public class ReverseStack {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        fabLastElement(stack);

    }


    /**
     * 得到栈底元素，
     * 递归方式
     *
     * @param stack
     * @return
     */
    public static int fabLastElement(Stack<Integer> stack) {
        int e = stack.pop();
        if (stack.isEmpty()) {
            return e;
        } else {
            int last = fabLastElement(stack);
            stack.push(e);
            return last;
        }
    }


    /**
     * 逆序一个栈
     *
     * @param stack
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = fabLastElement(stack);
        reverseStack(stack);
        stack.push(i);
    }
}
