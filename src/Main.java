import questions.Greedy.*;
import questions.LinkedList.*;
import questions.Math.*;
import questions.StackAndQueue.*;
import questions.UnionFInd.DisjointUnionSet;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();


        int stack1[] = { 3, 2, 1, 1, 1 };
        int stack2[] = { 4, 3, 2 };
        int stack3[] = { 1, 1, 4, 1 };

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        for (int val : stack1) st1.push(val);
        for (int val : stack2) st2.push(val);
        for (int val : stack3) st3.push(val);


        long ans = new FindMaximumSumPossibleEqualSumOfThreeStacks().solve(st1, st2, st3);
        System.out.println(ans);

        Test.giveMeString("Maximize array sum after K negations");
    }
}