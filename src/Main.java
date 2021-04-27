import questions.Matrix.*;
import questions.SearchAndSorting.*;
import questions.String.*;
import questions.array.*;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        char[][] mat = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'x', 'y'}};
        char[] pat = {'h','m','r','w'};
        int[][] matrix = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 25, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int res = new KthSmallestElementInARowWiseAndColumnWiseSortedTwoDArray().solve(matrix, 7);
        System.out.println(res);

        Test.giveMeString("A Boolean Matrix Question");
    }
}
