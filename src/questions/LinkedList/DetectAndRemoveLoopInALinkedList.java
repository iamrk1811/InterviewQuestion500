package questions.LinkedList;

public class DetectAndRemoveLoopInALinkedList {
//    Q - https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
    public ListNode solve(ListNode head) {
        if (head == null || head.next == null) return head;

//        detect loop
        ListNode slow = head, fast = head;

        ListNode prev = null;

        boolean isLoopExist = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            prev = fast.next;
            fast = fast.next.next;

            if (slow == fast) {
                isLoopExist = true;
                break;
            }
        }
//        remove loop
        if (isLoopExist) {
            slow = head;
            if (slow == fast) {
                prev.next = null;
                return head;
            }
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        fast.next = null;
        return head;
    }
}
