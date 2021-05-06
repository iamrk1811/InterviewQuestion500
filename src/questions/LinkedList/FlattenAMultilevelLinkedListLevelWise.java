package questions.LinkedList;

public class FlattenAMultilevelLinkedListLevelWise {
//    Q - https://www.geeksforgeeks.org/flatten-a-linked-list-with-next-and-child-pointers/
    public ListNode solve(ListNode head) {
        ListNode start = head;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        while (start != null) {
            if (start.bottom != null) {
                tail.next = start.bottom;
                while (tail.next != null) {
                    tail = tail.next;
                }
                start = start.next;
            }
        }
        return head;
    }
}
