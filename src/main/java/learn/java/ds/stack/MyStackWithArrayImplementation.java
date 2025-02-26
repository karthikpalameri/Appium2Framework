package learn.java.ds.stack;

class MySimpleArrayImplStack {
    int capacity;
    int top;
    int arr[];

    public MySimpleArrayImplStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        arr = new int[capacity];
    }

    public void push(int data) {
        //checks
        //check if stack is full
        if (this.top == this.capacity - 1) {
            System.out.println("Stack overflow");
        }

        //push
        this.top++;
        this.arr[this.top] = data;
    }

    public int pop() {
        //checks
        //check if stack is empty
        if (this.top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }

        //pop
        int val = this.arr[this.top];
        top--;
        return val;
    }

    public int peek() {
        //checks
        //check if stack is empty
        if (this.top == -1) {
            System.out.println("Stack underflow");
            return -1;
        }
        return this.arr[this.top];
    }
}

public class MyStackWithArrayImplementation {
    public static void main(String[] args) {
        MySimpleArrayImplStack stack = new MySimpleArrayImplStack(5);
        stack.push(1);
        stack.push(2);
        System.out.println("stack.pop() = " + stack.pop());
        stack.push(3);
    }
}
