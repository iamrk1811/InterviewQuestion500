package questions.LinkedList;

import java.util.Collections;
import java.util.List;

public class FindATripletFromThreeLinkedListsWithSumEqualToAGivenNumber {
//    Q - https://www.geeksforgeeks.org/find-a-triplet-from-three-linked-lists-with-sum-equal-to-a-given-number/
    public int[] solve(ListNode l1, ListNode l2, ListNode l3, int target) {
        ListNode list2 = mergeSort(l2);
        ListNode list3 = mergeSort(l3);
        ListNode list1 = l1;

        list3 = reverse(list3);

        ListNode list2Head = list2;
        ListNode list3Head = list3;
        int sum  = 0;
        while (list1 != null) {
            while (list2 != null && list3 != null) {
                sum = list1.data + list2.data + list3.data;
                if (sum == target)
                    return new int[]{list1.data, list2.data, list3.data};

                if (sum < target) {
                    list2 = list2.next;
                } else {
                    list3 = list3.next;
                }
            }
            list1 = list1.next;
            list2 = list2Head;
            list3 = list3Head;
        }
        return new int[]{};
    }
    private ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode mid = getMid(node);
        ListNode newMid = mid.next;
        mid.next = null;

        ListNode first = mergeSort(node);
        ListNode second = mergeSort((newMid));
        return mergeTwoSortedList(first, second);
    }
    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                prev.next = l1;
                l1 = l1.next;
                prev = prev.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;
            }
        }
        prev.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
    private ListNode getMid(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode prev = null, current = node, next = node.next;
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
