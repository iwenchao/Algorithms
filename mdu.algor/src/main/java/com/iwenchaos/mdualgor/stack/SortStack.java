package com.iwenchaos.mdualgor.stack;

import java.util.Stack;

/**
 * Created by chaos
 * on 2019/2/24. 16:40
 * 文件描述：
 */
public class SortStack {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

    }

    /**
     * @param stack
     */
    public static void sortStack(Stack<Integer> stack) {
        //先将stack元素 从从小到大的元素，或者从大到小 存放到help中
        Stack<Integer> help = new Stack<>();//help存放从从小到大的元素，或者从大到小
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            //
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        //再讲help元素赋值到stack中
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }

}
