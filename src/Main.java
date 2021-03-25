import questions.array.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] res = new ThreeWayPartitioning().solve(
          new int[]{1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}, 20, 35
        );
        System.out.println(Arrays.toString(res));
    }
}
