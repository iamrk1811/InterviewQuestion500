import questions.LinkedList.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();
        MyLinkedList list = new MyLinkedList();
        ListNode node = new ListNode(50, null);
        list.add(10);
        list.add(20);
        list.add(node);
        list.add(30);
        list.add(40);
        System.out.println(list);
        System.out.println(list.size);

        ListNode head = list.getHead();

        ListNode newHead = new ProgramForNthNodeFromTheEndOfALinkedList().solve(head, 1);

        list.display(newHead);



        Test.giveMeString("Program for nth node from the end of a Linked List");
    }
}
