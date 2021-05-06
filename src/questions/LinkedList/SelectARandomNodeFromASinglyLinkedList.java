package questions.LinkedList;

import java.util.Random;

public class SelectARandomNodeFromASinglyLinkedList {
//    Q - https://www.geeksforgeeks.org/select-a-random-node-from-a-singly-linked-list/
    public int getRandom(ListNode head) {
        int res = head.data;
        ListNode current = head;

        Random random = new Random();
        for (int i = 1; current != null; i++) {
            current = current.next;
            if (random.nextInt(i + 1) == i) {
                res = current.data;
            }
        }
        return res;
    }
}
