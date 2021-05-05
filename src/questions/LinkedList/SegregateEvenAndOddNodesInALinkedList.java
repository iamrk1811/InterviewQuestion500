package questions.LinkedList;

public class SegregateEvenAndOddNodesInALinkedList {
//    Q - https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
    public ListNode solve(ListNode head) {
        ListNode evenDummy = new ListNode(-1);
        ListNode even = evenDummy;
        ListNode oddDummy = new ListNode(-1);
        ListNode odd = oddDummy;

        while (head != null) {
            if (head.data % 2 == 0) {
                even.next = head;
                even = even.next;
                head = head.next;
            } else {
                odd.next = head;
                odd = odd.next;
                head = head.next;
            }
        }
        odd.next = null;
        even.next = oddDummy.next;
        return evenDummy.next;
    }
}
