package com.amioscode.datastructures;

import java.util.Stack;

public class WorkingStacks {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack);

        System.out.println(stack.get(1));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop());

    }

}
