package learn.java.ds.stack;

import java.util.ArrayList;

class MyStackWithArrayListImp {
    ArrayList<Integer> al;

    public MyStackWithArrayListImp() {
        al = new ArrayList<>();
    }

    public void push(int data) {
        //no checks as arraylist grows dynamically unlike array impl
        al.add(data);//adds at last
    }

    public int pop() {
        //checks
        if (!al.isEmpty()) {//al not empty then only insert
            int lastIndex = al.size() - 1;
            int res = al.remove(lastIndex);
            return res;
        }
        throw new RuntimeException("Stack is empty! unable to pop!");
    }

    public int peek() {
        //checks
        if (!al.isEmpty()) {
            int lastIndex = al.size() - 1;
            int res = al.get(lastIndex);
            return res;
        }
        throw new RuntimeException("Stack is empty! unable to peek!");
    }

    public int size() {
        return al.size();
    }
}

public class MyStackDemoWithArrayListImp {
    public static void main(String[] args) {

        MyStackWithArrayListImp myStack = new MyStackWithArrayListImp();//no size needed
        myStack.push(2);
        System.out.println("stack.pop() = " + myStack.pop());
        myStack.push(3);
        System.out.println("stack.peek() = " + myStack.peek());
        myStack.push(4);
        myStack.push(5);
    }
}
