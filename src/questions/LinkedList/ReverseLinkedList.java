package questions.LinkedList;

public class ReverseLinkedList {
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, current = head, next = head.next;

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
