package learn.java.ds.stack;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyStack {
    Node head;
    int size;

    MyStack() {
        head = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return head == null;
    }

    //null
    //10 null
    //h
    // insert at head
    void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp; // move head to temp
        size++;
    }

    int pop() {
        if (head == null) return -1;
        int res = head.data;
        head = head.next;
        return res;
    }

    int peek() {
        if (head == null) return -1;
        return head.data;
    }
}

public class MyStackDemoWithLinkedListImpl {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
