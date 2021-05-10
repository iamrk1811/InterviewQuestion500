import questions.LinkedList.*;
import questions.StackAndQueue.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();

        KQueueInAnArray queue = new KQueueInAnArray(3, 10);
        // Let us put some items in queue number 2
        queue.add(15, 2);
        queue.add(45, 2);

        // Let us put some items in queue number 1
        queue.add(17, 1);
        queue.add(49, 1);
        queue.add(39, 1);

        // Let us put some items in queue number 0
        queue.add(11, 0);
        queue.add(9, 0);
        queue.add(7, 0);
        System.out.println(queue.remove(2));
        System.out.println(queue.remove(1));
        System.out.println(queue.remove(0));
        int res = new CountNaturalNumbersWhoseAllPermutationAreGreaterThanThatNumber().solve(100);
        System.out.println(res);
        Test.giveMeString("Evaluation of Postfix Expression");
    }
}