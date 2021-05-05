package questions.LinkedList;

public class WriteAFunctionToGetTheIntersectionPointOfTwoLinkedLists {
    //    Q - https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
    public ListNode solve(ListNode head1, ListNode head2) {
        ListNode temp1 = head1, temp2 = head2;

        while (temp1 != null || temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if (temp1 == temp2) {
                return temp1;
            }

            if (temp1 == null) {
                temp1 = head1;
            }
            if (temp2 == null) {
                temp2 = head2;
            }
        }
        return null;
    }
}
