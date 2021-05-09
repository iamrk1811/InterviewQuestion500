package questions.StackAndQueue;

import questions.LinkedList.ListNode;

import java.util.stream.Stream;

public class DesignAStackWithOperationsOnMiddleElement {
    //    Q - https://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/
    ListNode head = null;
    ListNode mid = null;
    int size = 0;
    int midIndex = 0;

    public void push(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = mid = node;
            midIndex = 1;
            size++;
            return;
        }

        size++;
        head.next = node;
        node.prev = head;

        head = node;

        if (Math.ceil(size / 2.0) > midIndex) {
            mid = mid.next;
            midIndex++;
        }
    }

    public int pop() {
        if (head == null) return -1;
        if (size == 1) {
            head = mid = null;
            midIndex = 0;
            size = 0;
            return -1;
        }
        ListNode temp = head;
        head = head.prev;
        head.next = null;

        size--;

        if (Math.ceil(size / 2.0) < midIndex) {
            mid = mid.prev;
            midIndex--;
        }

        return temp.data;
    }

    public int findMid() {
        if (size == 0) return -1;
        return mid.data;
    }

    public int deleteMid() {
        if (head == null) return -1;

        if (size == 1) {
            int data = head.data;
            head = mid = null;
            size--;
            midIndex = 0;
            return data;
        }

        if (size == 2) {
            int data = head.data;
            ListNode prev = head.prev;
            prev.next = null;
            prev.prev = null;
            head = prev;
            size--;
            return data;
        }

        ListNode temp = mid;

        if (size > 2) {
            mid.prev.next = mid.next;
            mid.next.prev = mid.prev;
        }


        size--;
        if (Math.ceil(size / 2) < midIndex) {
            midIndex--;
            if (size % 2 == 0) {
                mid = temp.prev;
            } else {
                mid = temp.next;
            }
        }

        return temp.data;
    }

    public void display() {
        if (head == null) return;
        StringBuilder res = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            res.append(temp.data + "->");
            temp = temp.prev;
        }
        System.out.println(res);
    }
}
