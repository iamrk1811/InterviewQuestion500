package questions.LinkedList;

public class CloneALinkedListWithNextAndRandomPointer {
//    Q - https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
    public RandomNode solve(RandomNode head) {
        RandomNode current = head;

        while (current != null) {
            RandomNode node = new RandomNode(current.data);
            RandomNode temp = current.next;
            node.next = temp;
            current.next = node;
            current = temp;
        }
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        current = head;
        RandomNode newHead = current.next;
        RandomNode copy = newHead;
        while (current != null && copy != null) {
            current.next = current.next.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;

            current = current.next;
            copy = copy.next;
        }
        return newHead;
    }
}
