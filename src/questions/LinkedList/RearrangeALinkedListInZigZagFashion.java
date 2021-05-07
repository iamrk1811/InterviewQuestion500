package questions.LinkedList;

public class RearrangeALinkedListInZigZagFashion {
//    Q - https://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/
    public ListNode solve(ListNode head) {
        int flag = 0;
        ListNode original = head;
        while (head.next != null) {
            if (flag == 0) {
                if (head.data > head.next.data) {
                    int temp = head.data;
                    head.data = head.next.data;
                    head.next.data = temp;
                }
            } else {
                if (head.data < head.next.data) {
                    int temp = head.data;
                    head.data = head.next.data;
                    head.next.data = temp;
                }
            }
            flag = flag == 0? 1 : 0;
            head = head.next;
        }
        return original;
    }
}
