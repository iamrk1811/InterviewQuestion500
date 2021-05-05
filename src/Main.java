import questions.LinkedList.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();

        MyLinkedList list = new MyLinkedList();
        list.add(12);
        list.add(15);
        list.add(10);
        list.add(11);


        ListNode node = list.getHead();
//        ListNode sorted = new MergeSortForLinkedList().solve(node);
        ListNode ok = new DeleteNodesWhichHaveAGreaterValueOnRightSide().solve(node);
        MyLinkedList.display(ok);

        Test.giveMeString("Segregate even and odd nodes in a Linked List");
    }
}
