import questions.array.EquilibriumIndexOfAnArray;
import questions.array.FindSubArrayWithGivenSum;
import questions.array.KConcatenation;
import questions.array.LongestIncreasingSubsequenceLength;

public class Main {
    public static void main(String[] args) throws Exception {
       int res = new LongestIncreasingSubsequenceLength().solve(
               new int[]{
                       10,
                       22,
                       9,
                       33,
                       21,
                       50,
                       41,
                       60,
                       80,
                       1
               }
       );
        System.out.println(res);
    }
}
