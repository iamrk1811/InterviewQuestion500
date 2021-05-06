package questions.LinkedList;

import java.util.List;

public class FlatteningALinkedList {
//    Q - https://www.geeksforgeeks.org/flattening-a-linked-list/
    public ListNode solve(ListNode root) {
        return flatten(root);
    }

    private ListNode flatten(ListNode node) {
        if (node == null || node.next == null) return node;

        node.next = flatten(node.next);
        return mergeTwoList(node, node.next);
    }

    private ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                prev.bottom = node1;
                prev = prev.bottom;
                node1 = node1.bottom;
            } else {
                prev.bottom = node2;
                prev = prev.bottom;
                node2 = node2.bottom;
            }
        }
        prev.bottom = node1 == null ? node2 : node1;
        return dummy.bottom;
    }
}
