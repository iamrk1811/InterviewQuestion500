import questions.Greedy.*;
import questions.LinkedList.*;
import questions.Math.*;
import questions.OrderStatisticsHeapHash.FindTheMaximumRepeatingNumber;
import questions.OrderStatisticsHeapHash.FindTheSmallestPositiveNumberMissingFromAnUnsortedArray;
import questions.OrderStatisticsHeapHash.LengthOfTheLargestSubArrayWithContiguousElements;
import questions.OrderStatisticsHeapHash.SlidingWindowMaximum;
import questions.StackAndQueue.*;
import questions.UnionFInd.DisjointUnionSet;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();


        int[] arr = {10, 12, 12, 10, 10, 11, 10};



        int res = new LengthOfTheLargestSubArrayWithContiguousElements().solve(arr);
        System.out.println(res);



        Test.giveMeString("Length of the largest subarray with contiguous elements");
    }
}