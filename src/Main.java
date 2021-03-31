import questions.array.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        String res = new ArrangeGivenNumbersToFormTheBiggestNumber().solve(new String[]{
                "1", "34", "3", "98", "9", "76", "45", "4"
        });
        System.out.println(res);
        Test.giveMeString("Arrange given numbers to form the biggest number");
    }
}
