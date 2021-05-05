package questions.LinkedList;

import java.util.HashSet;

public class RemoveDuplicatesFromAnUnsortedLinkedList {
//    Q - https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
    public ListNode solve(ListNode node) {
        HashSet<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (node != null) {
            if (!set.contains(node.data)) {
                set.add(node.data);
                prev.next = node;
                node = node.next;
                prev = prev.next;
            } else {
                node = node.next;
            }

        }
        prev.next = null;
        return dummy.next;
    }
}
