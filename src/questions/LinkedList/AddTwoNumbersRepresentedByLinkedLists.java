package questions.LinkedList;

public class AddTwoNumbersRepresentedByLinkedLists {
//    Q - https://www.geeksforgeeks.org/sum-of-two-linked-lists/
    public ListNode solve(ListNode head1, ListNode head2) {
        ListNode l1 = reverse(head1);
        ListNode l2 = reverse(head2);
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.data;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.data;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        ListNode node = reverse(sentinel.next);
        return node;
    }
    private ListNode reverse(ListNode head) {
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
