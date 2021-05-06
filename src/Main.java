import questions.LinkedList.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();

        int[] arr = {1, 7, 3, 4};

        ListNode node = MyLinkedList.createListFromArray(arr);

        int res = new SelectARandomNodeFromASinglyLinkedList().getRandom(node);

        System.out.println( res);




        Test.giveMeString("Select a Random Node from a Singly Linked List");
    }
}