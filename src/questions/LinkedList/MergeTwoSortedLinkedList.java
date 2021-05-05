package questions.LinkedList;

public class MergeTwoSortedLinkedList {
    public ListNode solve(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        ListNode l1 = head1, l2 = head2;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
