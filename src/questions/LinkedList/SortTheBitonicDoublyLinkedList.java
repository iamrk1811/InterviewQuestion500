package questions.LinkedList;

public class SortTheBitonicDoublyLinkedList {
//    Q - https://www.geeksforgeeks.org/sort-biotonic-doubly-linked-list/
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode current = head;

        while (current != null) {
            if (prev.data > current.data) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) return head;

        prev.next = null;
        ListNode first = head;
        ListNode second = reverse(current);

        return mergeTwoSortedArray(first, second);
    }

    private ListNode mergeTwoSortedArray(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                prev.next = node1;
                node1 = node1.next;
            } else {
                prev.next = node2;
                node2 = node2.next;
            }
            prev = prev.next;
        }
        prev.next = node1 == null ? node2 : node1;
        return dummy.next;
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode prev = null, current = node, next = node.next;

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next = prev;

        return current;
    }
}
