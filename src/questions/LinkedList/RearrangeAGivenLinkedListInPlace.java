package questions.LinkedList;

import java.util.List;

public class RearrangeAGivenLinkedListInPlace {
//    Q - https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);
        ListNode newHead = mid.next;
        mid.next = null;

        ListNode first = head;
        ListNode second = reverse(newHead);


        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (first != null || second != null) {
            if (first != null) {
                prev.next = first;
                first = first.next;
                prev = prev.next;
            }
            if (second != null) {
                prev.next = second;
                second = second.next;
                prev = prev.next;
            }
        }

        return dummy.next;
    }
    private ListNode getMid(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode prev = null;

        ListNode current = node, next = node.next;

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
