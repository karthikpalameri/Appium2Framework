package learn.java.ds;

import java.util.stream.Collectors;

public class StackDemo {
    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.add(1);
        System.out.println("stack added with 1 = " + stack);
        stack.add(2);
        System.out.println("stack added with 2 = " + stack);
        System.out.println("stack.indexOf(1) = " + stack.indexOf(1));
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.empty() = " + stack.empty());
        System.out.println("stack.search(3) = " + stack.search(3));
        System.out.println("stack.size() = " + stack.size());
        System.out.println("adding 1 to 4 to stack again..");
        for (int i = 0; i < 5; i++) {
            stack.add(i);
        }
        System.out.println("stack.stream().collect(Collectors.toList()) = " + stack.stream().toList());
        System.out.println("printing using peek...");
        int size = stack.size();
        for (int i = 0; i <= size; i++) {
            if (!stack.empty()) {
                System.out.println("stack.pop() = " + stack.pop());
            }
        }
    }
}
