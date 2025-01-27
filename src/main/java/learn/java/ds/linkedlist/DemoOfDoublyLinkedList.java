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

    static Nodee deleteBegin(Nodee head) {
        //checks 
        //if no elements
        if (head == null)
            return null;

        //null<->[10|next:null,prev:null]
        //if only 1 element 
        if (head.next == null)
            return null;

        //move head to next node and set prev reference to null
        // null<->[10|prev:null, next:20]<->[20|prev:10, next:null]<->null
        // head
        //            head
        // null<-><->[20|prev:null, next:null]<->null

        head = head.next;//move head
        head.prev = null;//make prev ref as null
        return head;
    }

    static Nodee deleteEnd(Nodee head) {
        //checks
        //empty 
        if (head == null)
            return null;
        //only 1 node
        if (head.next == null)
            return null; //returning null as we are removing it.
        //30 20 10
        //h
        //   c

        Nodee curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        System.out.println("curr is at , curr.data = " + curr.data);

        curr.prev.next = null;// reach the end , go back and then set the next reference to null

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

//        head = deleteBegin(head);

        deleteEnd(head);
        System.out.println("head = " + head);
    }
}
