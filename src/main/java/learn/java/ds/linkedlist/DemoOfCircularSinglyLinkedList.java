package learn.java.ds.linkedlist;

class Nodeee {
    int data;
    Nodeee next;

    Nodeee(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DemoOfCircularSinglyLinkedList {
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

    private static Nodeee insertAtBeginnig(Nodeee head, int x) {
        //create a temp node with x data
        Nodeee temp = new Nodeee(x);

        //checks
        //if list is null or empty
        if (head == null) {
            temp.next = temp; // link it to itself
        } else {
            //10 20 30
            //      c
            //         100
            //go to last node of cirular singly linked list , insert it and modify the refernces
            Nodeee curr = head;
            while (curr.next != head)
                curr = curr.next;
            System.out.println("curr is now pointing to last node , curr.data = " + curr.data);
            // modify references
            curr.next = temp;
            temp.next = head;
        }
        //just return temp as head
        return temp;
    }

    private static Nodeee insertAtBeginnig2(Nodeee head, int x) {
        //create temp node
        Nodeee temp = new Nodeee(x);

        //checks
        //if list is empty
        if (head == null) {
            temp.next = temp;
            return temp;
        } else {
            //10 20 30
            //h
            //   100
            //   t

            //insert temp after the head and swap the data

            //link temp with next element of head
            temp.next = head.next;
            head.next = temp;

            //swap the data
            int tempValue = temp.data;
            temp.data = head.data;
            head.data = tempValue;
            return head;
        }
    }

    private static Nodeee insertAtEndOfCircularSinglyLinkedList(Nodeee head, int d) {
        //created new node
        Nodeee temp = new Nodeee(d);
        //checks
        //if empty linked list
        if (head == null) {
            //link it to itself
            temp.next = temp;
            return temp;
        } else {
            //10 20 30
            //h
            //       c
            //         100
            //          t
            //traverse till last node of list and insert and return the same head
            Nodeee curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            System.out.println("curr is now pointing to node, curr.data = " + curr.data);
            temp.next = head;
            curr.next = temp;

            //return head not temp
            return head;
        }
    }

    private static Nodeee insertAtEndOfCircularSinglyLinkedList2(Nodeee head, int x) {
        //insert at 2nd position and swap the data and return the temp , this will make the it insert at end
        //create a temp node
        Nodeee temp = new Nodeee(x);
        //checks
        //if list empty
        if (head == null) {
            temp.next = temp;
            return temp; //return temp as its only 1 element in list
        } else {
            //insert it in 2nd pos
            //10 20 30
            //h
            //   100
            //   t

            temp.next = head.next;//link right
            head.next = temp;//link left

            //now
            // 10 100 20 30
            // h   t

            //swap 100 with 10
            int tempVal = temp.data;
            temp.data = head.data;
            head.data = tempVal;

            //now
            //100 10 20 30
            //h   t

            //return temp , this will move the 100 automatically to last as its circular
            return temp;
        }
    }

    private static Nodeee deleteHeadOfCircularSinglyLinkedList(Nodeee head) {
        //checks
        //if empty
        if (head == null) {
            return null;
        }
        //if single element and its cirular then return null as we are deleting it
        if (head.next == head) {
            return null;
        }

        //10 20 30
        //h
        //      c
        Nodeee curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        System.out.println("Curr is not pointing to node curr.data =" + curr.data);

        curr.next = head.next;//link curr to head.next so we can deleted head
//        head = head.next;//move head to next ?

        return curr.next;// we are returning curr.next so we can get rid of head
    }

    private static Nodeee deleteHeadOfCircularSinglyLinkedList2(Nodeee head) {

        //checks
        //if empty
        if (head == null) {
            return null;
        }
        //if only 1 element
        if (head.next == head) { // check if its circular and only 1 element
            return null; // returning null as we are deleting it
        }

        // 10  20  30
        // h
        //copy middle 20 to head and delete head
        // 20  20  30
        //    del
        // 20  30

        head.data = head.next.data; //copy 20 to 1st post
        //del 20
        head.next = head.next.next;// we are deleted middle 20, so now list is 20,30
        return head;
    }

    private static Nodeee deleteKthElementFromCicularSinglyLinkedList(Nodeee head, int k) {
        //checks
        //if list empty
        if (head == null) {
            return null;
        }
        //if k =1
        // 10    20    30
        // h
        // k
        if (k == 1) {
            return deleteHeadOfCircularSinglyLinkedList2(head);
        }

        // if k != 1 ; ie., k=2
        // 10   20  30
        //      k
        // 0    1   2 // indexs
        // c         // curr

        Nodeee curr = head;
        for (int i = 0; i < k - 2; i++) {
            curr = curr.next; // tracers the curr till 1 las position i.e., 10
        }

        System.out.println("curr is now poining to node, curr.data =" + curr.data);

        //usng curr delete the kth element
        //linking
        curr.next = curr.next.next;
        return head;
    }

    private static boolean detectLoopUsingFloysCycleDetection(Nodeee head) {
        //checks
        //if empty
        if (head == null) {
            return false;
        }

        Nodeee slow = head;
        Nodeee fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop is present");
                return true;
            }
        }
        System.out.println("  Loop is not present");
        return false;
    }

    public static void main(String[] args) {
        Nodeee head = null;
        head = insertEnd(head, 10);
        head = insertEnd(head, 20);
        head = insertEnd(head, 30);

        head.next.next.next = head; // creating circular linked list


        circularLinkedListTraversal(head);
        circularLinkedListTraversal2(head);

//        insertAtBeginnig(head, 100);
//        insertAtBeginnig2(head, 100);

//        insertAtEndOfCircularSinglyLinkedList(head, 100);
//        insertAtEndOfCircularSinglyLinkedList2(head, 100);

//        deleteHeadOfCircularSinglyLinkedList(head);
//        deleteHeadOfCircularSinglyLinkedList2(head);

//        deleteKthElementFromCicularSinglyLinkedList(head, 1);

//        detectLoopUsingFloysCycleDetection(head);
        System.out.println("head  = " + head);
    }
}
