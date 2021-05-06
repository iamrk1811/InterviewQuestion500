package questions.LinkedList;

import java.util.List;

public class SortALinkedListOf0s1sAnd2s {
//    Q - https://www.geeksforgeeks.org/sort-a-linked-list-of-0s-1s-or-2s/
    public ListNode solve(ListNode head) {
        int[] count = new int[3];

        ListNode temp = head;
        while (temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }

        temp = head;
        int i = 0;

        while (temp != null) {
            if (count[i] == 0) {
                i++;
            } else {
                temp.data = i;
                count[i]--;
                temp = temp.next;
            }
        }
        return head;
    }
}
