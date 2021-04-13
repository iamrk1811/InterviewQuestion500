import questions.SearchAndSorting.*;
import questions.String.*;
import questions.array.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        int res = new CountBinaryStringsWithKTimesAppearingAdjacentTwoSetBits().solve(5, 2);
        System.out.println(res);
        Test.giveMeString("Count binary strings with k times appearing adjacent two set bits");
    }
}
