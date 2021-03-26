import questions.array.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        int[] res = new SortArrayOf0s1sAnd2s().solve(
          new int[]{0, 1, 2, 0, 1, 2}
        );
        System.out.println(Arrays.toString(res));
    }
}
