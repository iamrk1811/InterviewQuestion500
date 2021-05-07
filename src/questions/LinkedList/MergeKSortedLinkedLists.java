package questions.LinkedList;

public class MergeKSortedLinkedLists {
//    Q - https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
    public ListNode solve(ListNode[] arr, int k) {
        ListNode res = solution(arr, 0, arr.length - 1);
        return res;
    }

    ListNode solution(ListNode[] arr, int start, int end) {
        if (start > end) return null;
        if (start == end) return arr[start];

        int mid = (start + end) / 2;

        ListNode first = solution(arr, start, mid);
        ListNode second = solution(arr, mid + 1, end);

        return mergeTwoList(first, second);
    }
    ListNode mergeTwoList(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                prev.next = head1;
                prev = prev.next;
                head1 = head1.next;
            } else {
                prev.next = head2;
                prev = prev.next;
                head2 = head2.next;
            }
        }
        prev.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
