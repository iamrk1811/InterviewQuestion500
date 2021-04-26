import questions.Matrix.*;
import questions.SearchAndSorting.*;
import questions.String.*;
import questions.array.*;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] mat = {
                { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 6, 1, 3 },
                { -4, -1, 1, 7, -6 },
                { 0, -4, 10, -5, 1 }
        };
        System.out.println(new FindASpecificPairInMatrix().solve(mat));

        Test.giveMeString("Find a specific pair in Matrix");
    }
}
