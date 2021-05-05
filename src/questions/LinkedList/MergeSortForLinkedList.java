package questions.LinkedList;

public class MergeSortForLinkedList {
//    Q - https://www.geeksforgeeks.org/merge-sort-for-linked-list/
    public ListNode solve(ListNode head) {
        ListNode sortedNode = sort(head);
        return sortedNode;
    }
    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMid(head);

        ListNode newMid = mid.next;

        mid.next = null;

        ListNode first = sort(head);
        ListNode second = sort(newMid);
        ListNode mergeList = mergerTwoSortedList(first, second);
        return mergeList;
    }
    private ListNode getMid(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode temp = node;

        ListNode slow = temp, fast = temp;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergerTwoSortedList(ListNode head1, ListNode head2) {
        ListNode temp1 = head1, temp2 = head2;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                prev.next = temp1;
                temp1 = temp1.next;
            } else {
                prev.next = temp2;
                temp2 = temp2.next;
            }
            prev = prev.next;
        }

        prev.next = temp1 == null ?  temp2 : temp1;
        return dummy.next;
    }
}
