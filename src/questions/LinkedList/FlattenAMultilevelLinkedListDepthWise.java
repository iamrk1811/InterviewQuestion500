package questions.LinkedList;

public class FlattenAMultilevelLinkedListDepthWise {
//    Q - https://www.geeksforgeeks.org/flatten-a-multi-level-linked-list-set-2-depth-wise/
    public ListNode solve(ListNode node) {
        ListNode original = node;

        ListNode start = node;

        while (start != null) {
            if (start.bottom != null) {
                ListNode next = start.next;
                start.next = start.bottom;

                while (start.bottom.next != null) {
                    start.bottom = start.bottom.next;
                }
                start.bottom.next = next;
            }
            start = start.next;
        }
        return original;
    }
}
