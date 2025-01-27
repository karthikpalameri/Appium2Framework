package learn.java.ds.linkedlist;

class Nodee {
    Nodee next;
    Nodee prev;
    int data;

    Nodee(int x) {
        data = x;
        prev = null;
        next = null;
    }

}

public class DemoOfDoublyLinkedList {

    public static Nodee insertBegin(Nodee head, int x) {
        Nodee temp = new Nodee(x);
        if (head == null)
            return temp;
        temp.next = head;
        head.prev = temp;
        return temp;
    }

    static Nodee insertEnd(Nodee head, int x) {
        Nodee temp = new Nodee(x);
        // 10 20 
        // h
        // t
        //    c
        if (head == null)
            return temp; //temp is now head so return it
        Nodee curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = temp;
        temp.prev = curr;
        return head;
    }


    public static void main(String[] args) {
        Nodee head = null;
        head = insertBegin(head, 20);
        head = insertBegin(head, 10);

        head = insertEnd(head, 30);
        head = insertEnd(head, 40);
        System.out.println("head = " + head);
    }
}
