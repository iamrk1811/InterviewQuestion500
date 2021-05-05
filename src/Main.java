import questions.LinkedList.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();

        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        MyLinkedList list3 = new MyLinkedList();
        list1.add(20);
        list1.add(5);
        list1.add(15);
        list1.add(100);

        /*create a sorted linked list 'b' 2->4->9->10 */
        list2.add(10);
        list2.add(9);
        list2.add(4);
        list2.add(2);

        /*create another sorted linked list 'c' 8->4->2->1 */
        list3.add(1);
        list3.add(2);
        list3.add(4);
        list3.add(8);


        int[] arr = new FindATripletFromThreeLinkedListsWithSumEqualToAGivenNumber().solve(list1.getHead(), list2.getHead(), list3.getHead(), 25);
        System.out.println(Arrays.toString(arr));

        Test.giveMeString("Find a triplet from three linked lists with sum equal to a given number");
    }
}
