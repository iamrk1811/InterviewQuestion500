package questions.LinkedList;

public class RotateLinkedList {
//    Q - https://leetcode.com/problems/rotate-list
    public ListNode solve(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int len = 1;

        ListNode current = head;

        while (current.next != null) {
            current = current.next;
            len++;
        }

        k = len - k % len;

        if (len < k) return new ListNode();

        current.next = head;

        while (k-- > 0) {
            current = current.next;
        }

        head = current.next;
        current.next = null;

        return head;
    }
}
