package questions.LinkedList;

public class DeleteNodesWhichHaveAGreaterValueOnRightSide {
//    Q - https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode node = reverse(head);
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        int max = Integer.MIN_VALUE;
        while (node != null) {
            if (node.data >= max) {
                max = Math.max(max, node.data);
                prev.next = node;
                prev = node;
                node = node.next;
            } else {
                node = node.next;
            }
        }
        prev.next = null;
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
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
