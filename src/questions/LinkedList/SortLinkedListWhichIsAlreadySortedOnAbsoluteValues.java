package questions.LinkedList;

public class SortLinkedListWhichIsAlreadySortedOnAbsoluteValues {
//    Q - https://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            if (current.data < prev.data) {
                prev.next = current.next;
                current.next = head;
                head = current;
                current = prev;
            }
            else
                prev = current;
            current = current.next;
        }
        return head;
    }
}
