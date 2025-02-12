package learn.java.ds.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private static void printMiddleOfSinglyLinkedList(Node head) {
        //checks
        //if empty
        if (head == null) {
            return;
        }
        int count = 0;
        //find the middle
        for (Node curr = head; curr != null; curr = curr.next) {
            count++;
        }
        System.out.println("count = " + count);
        //bring back curr to head;
        Node curr = head;
        //move the curr to mid
        for (int i = 0; i < count / 2; i++) {
            curr = curr.next;
        }
        System.out.println("curr is now pointing to middle position , curr.data = " + curr.data);
    }

    private static void printMiddleOfSinglyLinkedList2(Node head) {
        //checks
        if (head == null) return;

        //10  20  30
        //h
        //f
        //s

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;//move 1 step at a time
            fast = fast.next.next;//move 2 steps at a time;
        }

        //after iteration slow should point to mid
        System.out.println("slow pointer is now pointing to mid i.e., ; slow.data = " + slow.data);
    }

    private static void printNthNodeFromtheEndOfSinglyLinkedList(Node head, int pos) {
        //checks
        //if empty
        if (head == null) return;
        // 10 20 30
        // 0   1  2
        //     p
        //size = 3
        //3-2 = 1
        // size - pos

        int size = 0;
        for (Node curr = head; curr != null && curr.next != null; curr = curr.next) {
            size++;
        }

        System.out.println("size = " + size);

        //if pos requested is greater then size return nothing
        if (pos > size) return;


        Node curr = head;
        for (int i = 0; i < (size - pos + 1); i++) {
            curr = curr.next;
        }

        System.out.println("curr.data = " + curr.data);
    }

    private static void printNthNodeFromtheEndOfSinglyLinkedList2(Node head, int pos) {
        //checks
        //if empty
        if (head == null) return;
        // pos = 3
        // 10 20 30 40 50 null
        // s         f
        //    s         f
        //        s        f

        // use 2 pointers and offset
        Node first = head;
        Node second = head;

        //keep pos = 3 ,offset distance between first and second and traverse till last

        for (int i = 0; i < pos; i++) {
            //checks
            if (first == null) {
                System.out.println("pos might be more than size of linked list pos = " + pos);
                return;
            }
            //move first  n times forward to create a offset
            first = first.next;
        }
        System.out.println("first is now pointing to, first.data = " + first.data);

        //traverse the first pointer till end
        while (first != null) {
            //keep the same speed for both the pointers to maintain offset
            first = first.next;
//            System.out.println("first.data = " + first.data);
            second = second.next;
            System.out.println("second.data = " + second.data);
        }

        System.out.println(" the second pointer will now be pointing to the Nth node from last , i.e., second.data = " + second.data);
    }

    private static Node removeDuplicatedFromSinglyLinkedList(Node head) {
        //checks
        if (head == null) return head;


        // temp

        // 10 10 10 40 50 50
        // c
        // 10 10 40 50 50
        // c
        // 10 40 50 50
        // c
        // 10 40 50 50
        //       c
        // 10 40 50 null
        //           c
        Node curr = head;
        while (curr != null && curr.next != null) {//keep iterating till end
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next; //if same link it to next node
            } else {
                curr = curr.next;// if not duplicate then and only then move the curr to next pos; the if will take care of repeated deletion
            }
        }
        return head;
    }

    private static Node reverseSinglyLinkedList(Node head) {
        //checks
        if (head == null) return head;

        List<Integer> arrList = new ArrayList<Integer>();
        for (Node curr = head; curr != null; curr = curr.next) {
            arrList.add(curr.data);
        }
        System.out.println("Arrays.asList(arrList) = " + Arrays.asList(arrList));

        for (Node curr = head; curr != null; curr = curr.next) {
            Integer remove = arrList.remove(arrList.size() - 1);//popped from last of arraylist
            curr.data = remove;//assignj
        }
        return head;
    }

    private static Node reverseSinglyLinkedList2(Node head) {
        //checks
        if (head == null) return head;

        //have 3 pointer prev, curr , next
        // next will hold temporarily the next node reference
        // now reverse link of curr to prev
        // then move prev 1 step forward using curr ref
        // then move curr 1 step forward using next ref

        //example :
        //10   20   30   40   50
        //h
        //p
        //c
        //n

        //     c
        //          n
        //p
        //  <-

        //     p
        //          c
        //
        Node prev = null;
        Node curr = head;

        curr = curr.next;
        while (curr != null) {
            Node next = curr.next; //next to hold next node ref
            curr.next = prev; // reverse the link to prev ref
            prev = curr; // move prev 1step forward using curr ref
            curr = next; // move curr 1step forward using next ref
        }
        //at last prev will be referring the last node as curr will be pointing to null
        //so return prev ref as new head;
        return head;
    }

    private static Node reverseSinglyLinkedListInGroupsOfSizeK(Node head, int k) {

        //10  20  30  40  50   60  70  80
        //c
        //f       p

        Node curr = head;
        Node prevFirst = null;
        boolean isFirstPass = true;
        while (curr != null) {
            Node first = curr;
            int count = 0;
            Node prev = null;
            while (curr != null && count < k) {
                //10 20 30  40
                // f
                //          c
                //          n
                //       p
                //       h
                // count = 3 ; 3rd iterarion ; prev should be the new head;
                Node next = curr.next;//hold next temporarily
                curr.next = prev; //prev will be null 1st
                prev = curr;// move prev 1 step forward
                curr = next;// move curr 1 step forward
                count++;
            }
            //curr will be pointing to 40 now in outer loop
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;// linking
            }
            prevFirst = first;//prevFirst will always hold starting point
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertBegin(head, 50);
        head = insertBegin(head, 40);
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

//        sortedInsertIntoSinglyLinkedList(head, 5);

//        printMiddleOfSinglyLinkedList(head);
//        printMiddleOfSinglyLinkedList2(head);

//        printNthNodeFromtheEndOfSinglyLinkedList2(head, 2);
//        printNthNodeFromtheEndOfSinglyLinkedList2(head, 2);

//        reverseSinglyLinkedList(head);
//        reverseSinglyLinkedList2(head);
//        printNthNodeFromtheEndOfSinglyLinkedList2(head, 2);

//        head = insertBegin(head, 10);
//        head = insertBegin(head, 10);
//        removeDuplicatedFromSinglyLinkedList(head);

        reverseSinglyLinkedListInGroupsOfSizeK(head, 3);

        System.out.println("head = " + head);
    }
}
