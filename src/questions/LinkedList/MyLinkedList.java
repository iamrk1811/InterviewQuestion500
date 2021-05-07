package questions.LinkedList;

import java.util.List;

public class MyLinkedList {
    ListNode head = null;
    ListNode tail = null;
    public int size = 0;

    public void add(ListNode node) {
        if (this.head == null) {
            this.head = node;
            this.size++;
            return;
        }
        ListNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        this.size++;
    }

    public static ListNode createListFromArray(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            if (temp == null) {
                temp = node;
            } else {
                temp.next = node;
            }
            temp = temp.next;
        }
        return dummy.next;
    }

    public static ListNode createDoublyListFromArray(int[] arr) {
        if (arr.length == 0) return new ListNode();

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            if (temp == null) {
                temp = node;
            } else {
                node.prev = temp;
            }
            temp = node;
        }

        ListNode last = temp;

        temp = temp.prev;


        while (temp != null) {
            temp.next = last;
            last = temp;
            temp = temp.prev;
        }

        return dummy.next;
    }

    public int delete() {
        if (head == null) {
            return -1;
        }
        if (head.next == null) {
            int deletedData = head.data;
            head = null;
            this.size--;
            return deletedData;
        }
        ListNode node = this.head;
        while (node.next.next != null) {
            node = node.next;
        }
        int deletedData = node.next.data;
        node.next = null;
        this.size--;

        return deletedData;
    }

    public void add(int data) {
        ListNode node = this.head;
        if (head == null) {
            head = new ListNode(data, null);
            tail = head;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            ListNode newNode = new ListNode(data, null);
            tail = newNode;
            node.next = newNode;
        }
        this.size++;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode temp = this.head;

        while (temp != null) {
            res.append(temp.data + "->");
            temp = temp.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void display(ListNode node) {
        ListNode temp = node;
        StringBuilder res = new StringBuilder();
        while (temp != null) {
            res.append(temp.data + "->");
            temp = temp.next;
        }
        res.append("NULL");
        System.out.println(res);
    }

    public static void displayBottom(ListNode node) {
        ListNode temp = node;
        StringBuilder res = new StringBuilder();
        while (temp != null) {
            res.append(temp.data + "->");
            temp = temp.bottom;
        }
        res.append("NULL");
        System.out.println(res);
    }

    public ListNode getHead() {
        return this.head;
    }

    public static void testDoublyList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode temp = head;

        ListNode tail = null;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            tail = temp;
            temp = temp.next;
        }
        System.out.println();
        while (tail != null) {
            System.out.print(tail.data + "<--");
            tail = tail.prev;
        }
        return;
    }
}
