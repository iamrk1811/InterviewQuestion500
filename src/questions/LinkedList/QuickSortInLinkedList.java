package questions.LinkedList;

public class QuickSortInLinkedList {
    //    Q - https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
    public void solve(ListNode node) {
        ListNode tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }
        sort(node, tail);
    }

    private void sort(ListNode start, ListNode end) {
        if(start == null || start == end|| start == end.next )
            return;

        ListNode pivotNode = partition(start, end);
        sort(start, pivotNode);
        sort(pivotNode.next, end);
    }

    public ListNode partition(ListNode start, ListNode end) {
        if (start == null || end == null || start == end) return start;

        int pivot = end.data;

        ListNode lastSwapNode = start;

        ListNode current = start;

        while (start != end) {
            if (start.data <= pivot) {
                lastSwapNode = current;
                int temp = start.data;
                start.data = current.data;
                current.data = temp;
                current = current.next;
            }
            start = start.next;
        }
        int temp = current.data;
        current.data = pivot;
        end.data = temp;
        return lastSwapNode;
    }
}
