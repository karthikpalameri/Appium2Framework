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

    public static Node delHead(Node head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node delLast(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return null;
        Node curr = head;
        // 10 20 30
        while (curr.next.next != null)
            curr = curr.next;
        curr.next = null;
        return head;
    }

    public static int search(Node head, int x) {
        int pos = 1;
        Node curr = head;
        while (curr != null) {
            if (curr.data == x) {
                return pos;
            } else {
                pos = pos + 1;
                curr = curr.next;
            }
        }
        return -1;
    }

    private static Node sortedInsertIntoSinglyLinkedList(Node head, int d) {
        Node temp = new Node(d);
        //checks
        //if empty
        if (head == null) {
            return null;
        }
        //if data is less than 1st elem
        if (d < head.data) {
            //insert data at 1st position and link
            //    10   20    30
            //    h
            // 5
            // d
            // t
            temp.next = head;
            return temp;
        }

        //10    20    30
        //h
        //         25
        //         t
        //      c
        //traverse till 1 step back where the data need to be inserted
        Node curr = head;
        while (curr.next != null && curr.next.data < d) {
            curr = curr.next;
        }
        System.out.println("curr pointer is now pointing to , curr.data = " + curr.data);

        curr.next = temp.next;
        curr.next = temp;

        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertBegin(head, 30);
        head = insertBegin(head, 20);
        head = insertBegin(head, 10);

//        head = null;
//        head = insertEnd(head, 40);
//        head = insertEnd(head, 50);
//        head = insertEnd(head, 60);

//        head = insertAtPosition(head, 4, 100);
//
//        head = delHead(head);
//        head = delLast(head);
//
//        int search = search(head, 40);
        sortedInsertIntoSinglyLinkedList(head, 5);
        System.out.println("head = " + head);
    }
}
