package questions.LinkedList;

import java.util.function.Predicate;

public class FindPairForGivenSumInASortedSinglyLinkedWithoutExtraSpace {
    //    Q - https://www.geeksforgeeks.org/find-pair-given-sum-sorted-singly-linked-without-extra-space/
    static class Node {
        Node prev;
        Node next;
        int data;
        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public void solve(ListNode list, int target) {
        if (list == null || list.next == null) return;

        Node head = new Node(list.data, null, null);

        Node prev = head;

        ListNode temp = list.next;
        while (temp != null) {
            Node node = new Node(temp.data, prev, null);
            prev = node;
            temp = temp.next;
        }
        Node current = prev;
        prev = prev.prev;
        while (prev != null) {
            prev.next = current;
            current = current.prev;
            prev = prev.prev;
        }

        Node start = head, tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        while (start != tail) {
            int sum = start.data + tail.data;
            if (sum == target)
                System.out.println(start.data + " + " + tail.data);

            if (sum > target) {
                tail = tail.prev;
            } else {
                start = start.next;
            }
        }
    }
}
