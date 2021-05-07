import questions.LinkedList.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();


        ListNode list1 = MyLinkedList.createDoublyListFromArray(new int[]{2, 5, 7, 12, 10, 6, 4, 1});

//        ListNode res = new SortLinkedListWhichIsAlreadySortedOnAbsoluteValues().solve(node);

//        MyLinkedList.display(res);

//        MyLinkedList.display(list1);

        ListNode node = new SortTheBitonicDoublyLinkedList().solve(list1);
        MyLinkedList.display(node);
        Test.giveMeString("Sort the biotonic doubly linked list");
    }
}