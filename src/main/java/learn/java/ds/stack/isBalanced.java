package learn.java.ds.stack;

import java.util.Stack;

public class isBalanced {
    static boolean isMatching(char a, char b) {
        return (a == '(' && b == ')' || a == '{' && b == '}' || a == '[' && b == ']');
    }

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            //if its opening brackets then push
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
            } else {
                //checks
                if (stack.isEmpty()) {
                    return false;
                } else if (!isMatching(stack.peek(), x)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        //at the end check if stack is empty or not
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("()[]{}"));
        System.out.println(isBalanced("([)]"));
        System.out.println(isBalanced("(){}[]"));

    }
}
