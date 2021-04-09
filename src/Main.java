import questions.SearchAndSorting.*;
import questions.array.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        String res = new FindTheLargestMultipleOfThree().solve(
                new int[]{
                        5, 8
                }
        );
        System.out.println(res);
        Test.giveMeString("Permute two arrays such that sum of every pair is greater or equal to K");
    }
}
