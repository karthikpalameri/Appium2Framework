package learn.java.ds;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    ListNode head;
    ListNode tail;
    int length;

    public class ListNode {
        int data;
        ListNode next;
        ListNode prev;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void displayForward() {
        if (head == null)
            return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        ListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        return temp;

    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(1);
        doublyLinkedList.insertFirst(2);
        doublyLinkedList.insertFirst(3);
        doublyLinkedList.insertEnd(10);
        doublyLinkedList.displayForward();
        doublyLinkedList.deleteFirst();
        doublyLinkedList.displayForward();
        doublyLinkedList.deleteLast();
        doublyLinkedList.displayForward();
    }
}
