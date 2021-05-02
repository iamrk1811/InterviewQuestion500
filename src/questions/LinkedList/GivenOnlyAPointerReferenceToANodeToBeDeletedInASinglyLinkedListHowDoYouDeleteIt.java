package questions.LinkedList;


public class GivenOnlyAPointerReferenceToANodeToBeDeletedInASinglyLinkedListHowDoYouDeleteIt {
//    Q - https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/
    public void delete(MyLinkedList linkedList, ListNode node) {
        ListNode temp = node;

        if (temp == null) return;
        if (temp.next == null) {
            temp = null;
            linkedList.size--;
            return;
        }
        ListNode prev = null;
        while (temp.next != null) {
            temp.data = temp.next.data;
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        linkedList.size--;
    }
}
