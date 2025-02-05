package learn.java.ds.linkedlist;


import lombok.extern.slf4j.Slf4j;

class Nodeeee {
    int data;
    Nodeeee prev;
    Nodeeee next;

    public Nodeeee(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

@Slf4j
public class DemoOfCircularDoublyLinkedList {
    private static Nodeeee insertAtBeginning(Nodeeee head, int x) {
        Nodeeee temp = new Nodeeee(x);
        //checks
        //if list empty
        if (head == null) {
            //insert and circular it
            temp.next = temp;
            temp.prev = temp;
            //set head as this temp node
            return temp;
        } else {
            // 10<->20<->30
            // h
            // 100
            // t
            //if non empty list
            //get access to head and last node , using head you can get hold of last node

            Nodeeee last = head.prev;//got hold of last node
            //link temp at beginn
            temp.next = head;
            head.prev = temp;

            temp.prev = last;
            last.next = temp;

            return temp;// note return temp as we have added at beginning
        }
    }

    private static Nodeeee insertAtEnd(Nodeeee head, int d) {
        //by default create temp node
        Nodeeee temp = new Nodeeee(d);
        //checks
        //if empty list
        if (head == null)
            return temp;
        else {
            //non empty list
            // 10 20 30
            // h
            //          500
            //           t
            //       l

            //get last node
            Nodeeee last = head.prev;
            //circular link it at end

            last.next = temp;
            temp.prev = last;

            temp.next = head;
            head.prev = temp;

            //now return the same head
            return head;
        }
    }

    private static Nodeeee insertNodeAfterGivenNode(Nodeeee head, int dataToFindToInsertAfter, int newDataToinsert) {
        Nodeeee temp = new Nodeeee(newDataToinsert);

        //checks
        //if empty list
        if (head == null) return null;
        else {
            //traverse
            Nodeeee curr = head;

            do {
                if (curr.data == dataToFindToInsertAfter) {
                    System.out.println("found data ,curr.data = " + curr.data);
                    //10 20        30
                    //h
                    //   c
                    //        99
                    //      <->t<->

                    temp.next = curr.next; //right side link done 1st to not lose right half
                    curr.next.prev = temp; //right next prev done

                    curr.next = temp;//left side link
                    temp.prev = curr;

                    return head;//break n return
                }
                //increment condition
                curr = curr.next;
            } while (curr != head);//if it reaches to head break
        }
        return head;
    }

    private static Nodeeee insertNodeBeforeGivenNode(Nodeeee head, int dataToFindToInsertBefor, int dataToInsert) {
        Nodeeee temp = new Nodeeee(dataToInsert);
        //checks
        if (head == null) return null;
        else {
            //traverse and find the node

            Nodeeee curr = head;
            do {
                if (curr.data == dataToFindToInsertBefor) {
                    //10     20      30
                    //h
                    //       c
                    //   199
                    //   t

                    curr.prev.next = temp;
                    temp.prev = curr.prev;

                    temp.next = curr;
                    curr.prev = temp;

                    return head;
                }
                //inc
                curr = curr.next;
            } while (curr.next != head);
        }
        return head;
    }

    private static void printList(Nodeeee head) {
        //checks
        //if list empty
        if (head == null) return;

        //if non empty
        //print 1st element to move the curr to 1 pos next so we can use curr!= head
        //10 20 30
        //h
        //c
        Nodeeee curr = head;
        //print 1st element
        System.out.println("---list elems are ---");
        System.out.println("curr.data = " + curr.data);
        curr = curr.next;
        do {
            System.out.println("curr.data = " + curr.data);
            curr = curr.next;
        } while (curr != head);
    }

    public static void main(String[] args) {
        // 10<-> 20 <-> 30
        Nodeeee head = new Nodeeee(10);
        head.next = new Nodeeee(20);
        // 10 -> 20
        // h
        // 10 <-> 20
        head.next.prev = head;

        //10<->20->30
        head.next.next = new Nodeeee(30);
        //10<->20<->30
        head.next.next.prev = head.next;

        //circular it
        head.next.next.next = head;//setting last nodes next
        head.prev = head.next.next;//setting heads prev
        // <->10<->20<->30<->

        //insert at beginn
//        insertAtBeginning(head, 100);
//        insertAtEnd(head, 500);

//        insertNodeAfterGivenNode(head,20, 99);
        insertNodeBeforeGivenNode(head, 20, 199);
        printList(head);
        System.out.println("head = " + head);
    }


}
