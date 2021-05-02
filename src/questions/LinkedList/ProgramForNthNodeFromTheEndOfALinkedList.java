package questions.LinkedList;


public class ProgramForNthNodeFromTheEndOfALinkedList {
//    Q - https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
    public ListNode solve(ListNode head, int num) {
        ListNode start = new ListNode();
        start.next = head;

        ListNode fast = start, slow = start;

        for (int i = 1; i <= num; i++) {
            if (fast.next == null) return null;
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }
}
