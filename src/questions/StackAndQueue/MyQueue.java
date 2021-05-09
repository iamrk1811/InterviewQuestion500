package questions.StackAndQueue;

import questions.LinkedList.ListNode;

public class MyQueue {
    private ListNode head = null, tail = null;
    private int size;

    public void add(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = tail = node;
            this.size++;
            return;
        }

        tail.next = node;
        tail = tail.next;
        this.size++;
    }

    public int remove() {
        if (head == null) return -1;

        int removedData = head.data;
        head = head.next;
        this.size--;
        return removedData;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        if (head == null) return res.toString();

        ListNode temp = head;

        while (temp != null) {
            res.append(temp.data + " ");
            temp = temp.next;
        }
        return res.toString();
    }

    public int peek() {
        return head == null ? -1 : head.data;
    }

}
