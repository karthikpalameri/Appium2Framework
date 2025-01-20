package learn.java.ds.linkedlist;

class Node {
    Node next;
    int data;

    Node(int x) {
        data = x;
        next = null;
    }

}

public class DemoOfSinglyLinkedList {

    public static Node insertBegin(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    public static Node insertEnd(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            return temp;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public static Node insertAtPosition(Node head, int pos, int x) {
        Node temp = new Node(x);
        if (pos == 1) {
            temp.next = head;
            return temp;
        }
        Node curr = head;
//        if (curr == null)
//            return head;
        //example
        // 10 20 30 40 50
        //  0  1  2  3  4
        //if pos =4 : n = 4-2=2;
        for (int i = 0; i <= pos - 2 && curr.next != null; i++) {
            curr = curr.next;
        }
        if (curr == null)
            return head;

        //properly link it
        temp.next = curr.next; //first store this before its lost
        curr.next = temp;
        return head; //always return head at last

    }

    public static void main(String[] args) {
        Node head = null;
        head = insertBegin(head, 30);
        head = insertBegin(head, 20);
        head = insertBegin(head, 10);

        head = null;
        head = insertEnd(head, 40);
//        head = insertEnd(head, 50);
//        head = insertEnd(head, 60);

//        head = null;
        head = insertAtPosition(head, 4, 100);

        System.out.println("head = " + head);
    }
}
