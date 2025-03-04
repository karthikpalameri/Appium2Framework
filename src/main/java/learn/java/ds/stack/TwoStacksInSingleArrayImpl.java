package learn.java.ds.stack;

public class TwoStacksInSingleArrayImpl {
    Integer[] arr;
    int top1;
    int top2;
    int cap;

    // example
    //    10 20 30  null
    // t1
    //              t2
    // -1 0  1  2    3 //indexes ; note indexes where the top1 and top2 should point initially;t1=-1 and t2 =3;
    //
    //    1  2  3     //size;

    public TwoStacksInSingleArrayImpl(int size) {
        arr = new Integer[size];
        top1 = -1; // park at -1 index
        top2 = size; //note: park at null which is also equal to the size of the stack ie.,3 which on index always points to null
        this.cap = size;
    }

    public boolean push1(int data) {
        //checks
        //   10 20  null
        //t1         t2

        if (top1 < top2 - 1) { //note : 1 space should be available to insert from left so -1 check
            top1++;
            arr[top1] = data;
            return true;
        }
        System.out.println("\"Stack is full\" = " + "Stack is full");
        return false;
    }

    public boolean push2(int data) {
        //checks
        //   10  20  30 null
        //t1             t2
        //-1  0   1   2
        //            t1 t2  //space check , no space to insert as 2<(3-1); 2<2 false
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = data;
            return true;
        }
        System.out.println("\"Stack is full\" = " + "Stack is full");
        return false;
    }

    public Integer pop1() {
        //checks ; check if underflow
        //   10  20  30  null
        //-1 0    1   2   3
        //t1              t2
        if (top1 > -1) { // should not be -1
            int res = arr[top1]; //get
            top1--;// //note: we are moving the top1 the left side
            return res;
        }
        System.out.println("\"Stack1 underflow unable to pop\" = " + "Stack1 underflow unable to pop");
        return null;// return null as Integer return type
    }

    public Integer pop2() {
        //checks
        //   10   20  30  null
        //-1 0     1   2   3 //index
        //   1     2   3 //size
        //t1               t2
        //check underflow
        if (top2 < cap) { // note: its should be less than size - 1; 3-1=2 i.e., to get that 1 elem to pop
            int res = arr[top2];
            top2++; //note: we are moving the top2 the right side
            return res;
        }

        System.out.println("\"Stack2 underflow unable to pop\" = " + "Stack1 underflow unable to pop");
        return null;
    }

    public Integer peek1() {
        //checks
        //   10   20  30  null
        //-1 0     1   2   3 //index
        //   1     2   3 //size
        //t1               t2
        if (top1 > -1) {
            return arr[top1];
        }
        return null;
    }

    public Integer peek2() {
        //checks
        //   10   20  30  null
        //-1 0     1   2   3 //index
        //   1     2   3 //size
        //t1               t2
        if (top2 < cap) { // ex 3-1 = 2; not pointing to null check
            return arr[top2];
        }
        return null;
    }

    public Integer size1() {
        return (top1 + 1);
    }

    public Integer size2() {
        return (cap - top2);
    }

    public static void main(String[] args) {
        TwoStacksInSingleArrayImpl myStack = new TwoStacksInSingleArrayImpl(3);
        System.out.println("myStack.size1() = " + myStack.size1());
        System.out.println("myStack.size2() = " + myStack.size2());

        myStack.push1(10);
        myStack.push1(20);
        myStack.push2(100);
        myStack.push2(200);
        System.out.println("myStack.peek1() = " + myStack.peek1());
        System.out.println("myStack.peek2() = " + myStack.peek2());

        myStack.push1(30);
        myStack.push2(200);

        System.out.println("myStack.pop1() = " + myStack.pop1());
        System.out.println("myStack.pop2() = " + myStack.pop2());

    }
}
