package learn.java.ds.linkedlist;

class Nodeee {
    int data;
    Nodeee next;

    Nodeee(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DemoOfCircularLinkedList {
    static Nodeee insertEnd(Nodeee head, int data) {
        //create 1 node
        Nodeee temp = new Nodeee(data);

        //checks if no elements then return emty node with data
        if (head == null)
            return temp;

        //create curr for traversal 
        Nodeee curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }
        System.out.println(" curr is now pointing to, curr.data = " + curr.data);

        //link the newly created temp to curr
        curr.next = temp;

        //return head 
        return head;
    }

    static void circularLinkedListTraversal(Nodeee head) {
        //checks
        //empty 
        if (head == null)
            return;
        //print 1st node as we are skiping in for loop
        System.out.println("head.data = " + head.data);
        for (Nodeee x = head.next; x != head; x = x.next) { //start with head.next so it does not end at 1st iter
            System.out.println("x.data = " + x.data);
        }
    }

    private static void circularLinkedListTraversal2(Nodeee head) {
        //checks 
        //if empty 
        if (head == null)
            return;

        Nodeee x = head; //point x to head 

        //first print so the x!=head

        // 10 20 30 
        // x
        //    x

        System.out.println("-------------");
        do {
            System.out.println("x.data = " + x.data);
            x = x.next;// move it 1 forward
        } while (x != head);//do while x is not reached back to head
    }

    public static void main(String[] args) {
        Nodeee head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);

        head.next.next.next = head; // creating circular linked list


        circularLinkedListTraversal(head);
        circularLinkedListTraversal2(head);
        System.out.println("head = " + head);
    }
}
