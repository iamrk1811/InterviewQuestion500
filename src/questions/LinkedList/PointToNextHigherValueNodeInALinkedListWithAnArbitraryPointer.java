package questions.LinkedList;

public class PointToNextHigherValueNodeInALinkedListWithAnArbitraryPointer {
//    Q - https://www.geeksforgeeks.org/point-to-next-higher-value-node-in-a-linked-list-with-an-arbitrary-pointer/
    public RandomNode solve(RandomNode head) {
        RandomNode temp = head;

        while (temp != null) {
            temp.random = temp.next;
            temp = temp.next;
        }

        RandomNode sortedList = mergeSort(head);

        return sortedList;
    }
    private RandomNode mergeSort(RandomNode node) {
        if (node == null || node.random == null) return node;

        RandomNode mid = getMid(node);
        RandomNode newMid= mid.random;
        mid.random = null;

        RandomNode first = mergeSort(node);
        RandomNode second = mergeSort(newMid);
        return mergeTwoSortedList(first, second);
    }
    private RandomNode mergeTwoSortedList(RandomNode node1, RandomNode node2) {
        RandomNode l1 = node1, l2 = node2;
        RandomNode dummy = new RandomNode(-1);
        RandomNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                prev.random = l1;
                prev = prev.random;
                l1 = l1.random;
            } else {
                prev.random = l2;
                l2 = l2.random;
                prev = prev.random;
            }
        }
        prev.random = l2 == null ? l1 : l2;
        return dummy.random;
    }
    private RandomNode getMid(RandomNode node) {
        if (node == null && node.random == null) return node;

        RandomNode slow = node, fast = node;
        while (fast.random != null && fast.random.random != null) {
            slow = slow.random;
            fast = fast.random.random;
        }
        return slow;
    }
}
