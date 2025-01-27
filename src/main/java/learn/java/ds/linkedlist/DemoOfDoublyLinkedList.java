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

    static Nodee reverseDoublyLinkedList(Nodee head) {
        //corner case handle 
        if (head == null)
            return head;
        if (head.next == null)
            return head;

        //init prev and next as null
        Nodee prev = null;
        Nodee next = null;
        Nodee curr = head;

        //   n
        // 10 20 30 
        //   
        // h
        // c

        //Initial 
        // null<->[10|prev:null, next:20] <-> [20|prev:10, next:30]<-> [30|prev:20, next:null]<->null

/*
         prev = null        
         null<->[10|prev:null, next:20] <-> [20|prev:10, next:30]<-> [30|prev:20, next:null]<->null
         curr
         
                                            prev = 20
         null<->[10|prev:20, next:null] <-> [20|prev:10, next:30]<-> [30|prev:20, next:null]<->null
                                            curr
         
         
                                                                     prev = 30
         null<->[10|prev:20, next:null] <-> [20|prev:30, next:10]<-> [30|prev:20, next:null]<->null
                                                                     curr

                                             
                                                                     prev = 30
         null<->[10|prev:20, next:null] <-> [20|prev:30, next:10]<-> [30|prev:20, next:null]<->null
                                                                     curr
*/


        while (curr.next != null) {
            //swap pointer
            //swap curr.next with curr.prev
            prev = curr.next;
            curr.next = curr.prev;
            curr.prev = prev;

            //move the curr to right
            curr = curr.prev;// note we reversed the pointers
        }
        return prev.prev;
    }


    public static void main(String[] args) {
        Nodee head = null;
        head = insertBegin(head, 20);
        head = insertBegin(head, 10);

        head = insertEnd(head, 30);
        head = insertEnd(head, 40);

        //reverse doubly linked list 
        head = reverseDoublyLinkedList(head);
        System.out.println("head = " + head);
    }
}
