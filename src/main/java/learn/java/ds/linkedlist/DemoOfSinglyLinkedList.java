package learn.java.ds.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    Node next;
    Node random;//not needed
    int data;

    Node(int x) {
        data = x;
        next = null;
        random = null;//not needed
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

    private static void deleteGivenNodeInSiglyLikedList(Node toDelete) {
        // 5 10 20 30 40 50
        //10 10 20 30 40 50
        //10 20 30 40 50

        toDelete.data = toDelete.next.data; //copy data
        toDelete.next = toDelete.next.next; // just skip and link os it will delink

        System.out.println("Deleted given Node");
    }

    private static Node segregateEvenAndOddInSinglyLinkedList(Node head) {

        // 1 2 3 4 5
        // make 2 seperate links for odd and even and ten append it

        Node curr = head;
        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (evenStart == null && evenEnd == null) {
                    evenStart = curr;
                    evenEnd = curr;
                } else {
                    evenEnd.next = curr;//link it to next even
                    evenEnd = evenEnd.next; //move the evenEnd pointer to next even node
                }
            } else {
                if (oddStart == null && oddEnd == null) {
                    oddStart = curr;
                    oddEnd = curr;
                } else {
                    oddEnd.next = curr; // link it to curr ref
                    oddEnd = oddEnd.next; //move the oddEnd pointer to next odd node
                }
            }
            curr = curr.next;
        }

        //corner case if all are odd or even in a ll
        if (evenStart == null || oddStart == null) {
            return head;// we will only make 1 ll , and head will remain head , no need to link to other ll
        }
        //at this point we will have 2 linked nodes even ll and odd ll
        //link both to make 1ll
        evenEnd.next = oddStart; //linking
        oddEnd.next = null; //making the end of the ll null at last node
        return evenStart;
    }

    private static int isIntersectionPointOfTwoLinkedList(Node head1, Node head2) {
        //checks

        //ex
        // 50  40  30  20  10 ; head1
        //        /
        //     99             ; head2
        // 1   2   3   4   5 ; size = 5
        //     1   2   3   4 ; size = 4
        // diff = 5 - 4 = 1
        //     c1
        //     c2

        //if we sub head 1 length and head2 length we get common point where we can start traversing to find if intersection exists

        //find size of both heads
        int head1size = findSizeOfSinglyLinkedList(head1);
        int head2size = findSizeOfSinglyLinkedList(head2);
        int diff = Math.abs(head1size - head2size);
        System.out.println("diff = " + diff);

        //find the head which is largest and move sett curr1 to diff position
        Node largestLinkedList = head1size > head2size ? head1 : head2;

        Node curr1 = head1;
        for (int i = 0; i < diff; i++) {
            //move curr1 to diff pos
            curr1 = curr1.next;
        }

        Node curr2 = head2;
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1.data;
            }
            //conditions for while
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return -1; //
    }

    private static int findSizeOfSinglyLinkedList(Node head) {
        int count = 0;

        //checks
        if (head == null) return 0;
        //ex
        // 1 2 3
        //
        for (Node curr = head; curr != null; curr = curr.next) {
            count++;
        }
        return count;
    }

    private static Node cloneASinglyLinkedListWithRandomPointer(Node head) {
        //checks
        if (head == null) return head;

        //example
        // |--->|
        // 1 -> 2 -> 3
        // |<---|<---|

        // c    n
        //1st insert same elements in middle then copy the link refs to inserted elemnts
        //at last seperate them

        //step1 ins same elems
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;//holds next elem ie., 2
            curr.next = new Node(curr.data); //create new node with curr.data and link to curr ref; 1->1 2->3
            curr.next.next = next;//1->1->2  ->3
            curr = next; //move the curr to where next was pointing
        }

        //1->1->2->2->3->3->null

        //step2 copy the old random refs to the new nodes
        for (Node curr2 = head; curr2 != null; curr2 = curr2.next.next) {
            curr2.next.random = curr2.random != null ? curr2.random : null;
        }

        //step 3 seperate the 2 nodes
        Node head2 = head.next; // keep track of clone head which starts from 1 step after ; so store in head2
        Node clone = head2;

        for (Node curr3 = head; curr3 != null; curr3 = curr3.next) {
            curr3.next = curr3.next.next;
            clone.next = clone.next != null ? clone.next : null;
            clone = clone.next;// incrementer for clone
        }
        return head2; //return head2 ie., clone head

    }

    private static Node mergeTwoSortedSinglyLinkedLists(Node sortedHead1, Node sortedHead2) {
        //checks
        //if 1 is ssl is null return other
        if (sortedHead1 == null)
            return sortedHead2;
        if (sortedHead2 == null)
            return sortedHead1;
// head and tail pointers to track start and end
        Node head = null;
        Node tail = null;
        if (sortedHead1.data < sortedHead2.data) {
            //whichever is less ,assign head and tail to it to start the iteration
            head = sortedHead1;
            tail = sortedHead2;
            //move the sortedHead1 to 1 step forward in the smallest ll
            sortedHead1 = sortedHead1.next;
        } else {
            head = sortedHead2;
            tail = sortedHead2;
            //move the sortedHead2 to 1 step forward in the smallest ll
            sortedHead2 = sortedHead2.next;
        }
        // #1 : sortedHead1 -> 10 ; sortedHead2 -> 35 ; head - 5 ; tail = 5;
        //ex
        //       t->
        //           h1
        // 10 20 30  null
        // 5  35
        //    h2
        // h
        //
        // #2 : sortedHead1 -> 20 ; sortedHead2 -> 35 ; head = 5 ; tail = 10;
        // #3 : sortedHead1 -> 30 ; sortedHead2 -> 35 ; head = 5; tail = 20 ;
        // #4 : sortedHead1 -> null; sortedHead2 ->35 ; head = 5; tail = 30 ;
        // loop break;

        // note : the remaining elements of sll are not traversed from 35 , append them to the end of tail to not loose them

        //now head and tail are set ,start the iteration
        while (sortedHead1 != null && sortedHead2 != null) { // if one of them is null break the loop
            // compare the smallest between 2 sll
            // assign the link and then move 1 step foraward in the smallest ll
            // and assign tail to it
            if (sortedHead1.data < sortedHead2.data) {
                tail.next = sortedHead1; //assign link so that we can move tail
                tail = sortedHead1; // move tail to sortedHead1
                sortedHead1 = sortedHead1.next; // move sortedHead1 1 step forward
            } else {
                tail.next = sortedHead2; //assign link so that we can move tail
                tail = sortedHead2; // move tail to sortedHead2
                sortedHead2 = sortedHead2.next; // move sortedHead2 1 step forward
            }

        }

        //append the remaining elements of linked list to the end of the tail ref
        if (sortedHead1 == null) { //if this sortedHead1 hit null then append then its traversed fully
            tail.next = sortedHead2; //link the tail ref to the sortedHead2 to not loose elements
        } else {
            tail.next = sortedHead1; //link the tail ref to the sortedHead1 to not loose elements
        }
        return head; //return head which is the start of the merged sll
    }


    private static boolean isPalindrome(Node head) {

        //palindrome sll
        //r a c e c a r
        //0 1 2 3 4 5 6
        // 7/2 = 3
        //      m
        //r a c e r a c
        //      m
        //compare before mid and after mid each element

        //checks
        if (head == null) return false;
        //step1: find the 1st mid using slow and fast pointers at 1 and 2 movement speed
        //ex
        //1  2  2  1  null
        //   s
        //      f
        //mid = 2
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) { //fast should always check 2 steps forward
            slow = slow.next; // 1 move speed
            fast = fast.next.next; // 2 move speed
        }

        //step2: reverse all the elements from mid to tail
        Node revHead = reverseSinglyLinkedList(fast);
        //1  2  1  2 null
        //   m  r
        //h
        //c

        //step3: compare head with mid+1 till end
        Node curr = head;
        while (revHead != null) { //traverse till not null
            if (curr.data != revHead.data) { // 1!=1; 2!=2
                //step4: break if not matching
                return false;
            }
            //increment
            curr = curr.next;
            revHead = revHead.next;
        }

        return true; // return true if not breaking
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

//        reverseSinglyLinkedListInGroupsOfSizeK(head, 3);

//        Node toDelete = insertBegin(head, 10);
//        deleteGivenNodeInSiglyLikedList(toDelete);

//        segregateEvenAndOddInSinglyLinkedList(head);//passing all even nodes as test ; head has all even nodes

        //find intersection point of 2 linked lists
//        head2 = insertBegin(head2, 99);
//        int intersectionPointOfTwoLinkedList = isIntersectionPointOfTwoLinkedList(head, head2);
//        System.out.println("intersectionPointOfTwoLinkedList = " + intersectionPointOfTwoLinkedList);

        //setup random references before
//        cloneASinglyLinkedListWithRandomPointer(head);

        // merge 2 sorted singly linked list
//        Node sortedHead1 = null;
//        sortedHead1 = insertEnd(sortedHead1, 10);
//        sortedHead1 = insertEnd(sortedHead1, 20);
//        sortedHead1 = insertEnd(sortedHead1, 30);
//
//        Node sortedHead2 = null;
//        sortedHead2 = insertEnd(sortedHead2, 5);
//        sortedHead2 = insertEnd(sortedHead2, 35);
//
//        mergeTwoSortedSinglyLinkedLists(sortedHead1, sortedHead2);


        //isPalindrome
        Node palindromeHead = null;
        // 1 2 2 1
        palindromeHead = insertEnd(palindromeHead, 1);
        palindromeHead = insertEnd(palindromeHead, 2);
        palindromeHead = insertEnd(palindromeHead, 2);
        palindromeHead = insertEnd(palindromeHead, 1);
        boolean palindrome = isPalindrome(palindromeHead);
        System.out.println("palindrome = " + palindrome);

        System.out.println("head = " + head);
    }

}
