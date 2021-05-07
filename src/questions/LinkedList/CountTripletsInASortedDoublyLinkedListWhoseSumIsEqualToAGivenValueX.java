package questions.LinkedList;

public class CountTripletsInASortedDoublyLinkedListWhoseSumIsEqualToAGivenValueX {
//    Q - https://www.geeksforgeeks.org/count-triplets-sorted-doubly-linked-list-whose-sum-equal-given-value-x/
    public void solve(ListNode head, int target) {
        if (head == null || head.next == null) return;
        int len = 1;
        ListNode current = head;

        while (current.next != null) {
            len++;
            current = current.next;
        }

        if (len < 3) return;

        solution(head, target);
    }

    private void solution(ListNode head, int target) {

        ListNode tail = null;

        ListNode current = head;

        while (current.next != null) {
            current = current.next;
        }
        tail = current;

        ListNode i = head;
        while (i != null) {
            ListNode j = i.next;
            ListNode k = tail;
            int remain = target - i.data;
            while (j != null && k != null && j != k && k.next != j) {
                int sum = j.data + k.data;

                if (sum == remain) {
                    System.out.println(i.data + " + " + j.data + " + " + k.data);
                }
                if (sum < remain) {
                    j = j.next;
                } else {
                    k = k.prev;
                }
            }
            i = i.next;
        }
    }
}
