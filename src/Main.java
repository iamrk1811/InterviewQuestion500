import questions.Backtracking.*;
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
        char[] pat = {'h', 'm', 'r', 'w'};
        int[][] matrix = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        System.out.println(new MatchAPatternAndStringWithoutUsingRegularExpressions().solve("graphstreegraphs", "aba"));
        Test.giveMeString("Match a pattern and String without using regular expressions");
    }
}
