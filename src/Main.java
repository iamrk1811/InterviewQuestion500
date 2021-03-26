import questions.array.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        int[] res  =new MoveAllZeroesToEndOfArray().solve(
                new int[]{
                        1, 2, 0, 0, 0, 3, 6
                }
        );

        System.out.println(Arrays.toString(res));
    }
}
